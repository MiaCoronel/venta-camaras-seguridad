package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Carrito;
import com.ventacamaras.camaras.model.ItemCarrito;
import com.ventacamaras.camaras.repository.CarritoRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    // Busca el carrito ID 1. Si no hay ninguno en la base de datos, crea uno nuevo.
    public Carrito obtenerCarrito() {
        return carritoRepository.findById(1L).orElseGet(() -> {
            Carrito nuevoCarrito = new Carrito();
            return carritoRepository.save(nuevoCarrito);
        });
    }

    public void agregarItem(ItemCarrito item) {
        Carrito carrito = obtenerCarrito();
        item.setCarrito(carrito); // Establece la relación inversa
        carrito.getItems().add(item);
        carritoRepository.save(carrito); // Al guardar el carrito, JPA guarda el item gracias al CascadeType.ALL
    }

    public void eliminarItem(Long productoId) {
        Carrito carrito = obtenerCarrito();
        carrito.getItems().removeIf(i -> i.getProductoId().equals(productoId));
        carritoRepository.save(carrito);
    }

    public void vaciarCarrito() {
        Carrito carrito = obtenerCarrito();
        carrito.getItems().clear();
        carritoRepository.save(carrito);
    }
}