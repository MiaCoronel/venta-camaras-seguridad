package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Camara;
import com.ventacamaras.camaras.model.Carrito;
import com.ventacamaras.camaras.model.ItemCarrito;
import com.ventacamaras.camaras.model.User;
import com.ventacamaras.camaras.repository.CamaraRepository;
import com.ventacamaras.camaras.repository.CarritoRepository;
import com.ventacamaras.camaras.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarritoService {

    private final CarritoRepository carritoRepository;
    private final CamaraRepository camaraRepository;
    private final UserRepository userRepository;

    @Transactional
    public Carrito agregarItemAlCarrito(String username, Long camaraId, Integer cantidad) {
        
        User usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Camara camara = camaraRepository.findById(camaraId)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada"));

        if (camara.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente para esta cámara. Stock actual: " + camara.getStock());
        }

        Carrito carrito = carritoRepository.findByUsuarioUsernameConItems(username)
                .orElseGet(() -> {
                    Carrito nuevoCarrito = Carrito.builder().usuario(usuario).build();
                    return carritoRepository.save(nuevoCarrito);
                });

        Optional<ItemCarrito> itemExistente = carrito.getItems().stream()
                .filter(item -> item.getCamara().getId().equals(camaraId))
                .findFirst();

        if (itemExistente.isPresent()) {
            ItemCarrito item = itemExistente.get();
            // Ya no seteamos el subtotal porque se calcula solo
            item.setCantidad(item.getCantidad() + cantidad);
        } else {
            ItemCarrito nuevoItem = ItemCarrito.builder()
                    .carrito(carrito)
                    .camara(camara)
                    .cantidad(cantidad)
                    .precioUnitario(camara.getPrecio())
                    // Tampoco seteamos el subtotal aquí
                    .build();
            carrito.getItems().add(nuevoItem);
        }

        // Ya no seteamos el total del carrito, @Transient hace el trabajo
        return carritoRepository.save(carrito);
    }
}