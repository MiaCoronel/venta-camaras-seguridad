package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Carrito;
import com.ventacamaras.camaras.model.ItemCarrito;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    private Carrito carrito = new Carrito();

    public Carrito obtenerCarrito() {
        return carrito;
    }

    public void agregarItem(ItemCarrito item) {
        carrito.getItems().add(item);
    }

    public void eliminarItem(Long productoId) {
        carrito.getItems().removeIf(i -> i.getProductoId().equals(productoId));
    }

    public void vaciarCarrito() {
        carrito.getItems().clear();
    }
}