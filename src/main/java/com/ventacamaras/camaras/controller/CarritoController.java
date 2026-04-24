package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.Carrito;
import com.ventacamaras.camaras.model.ItemCarrito;
import com.ventacamaras.camaras.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public Carrito verCarrito() {
        return carritoService.obtenerCarrito();
    }

    @PostMapping
    public String agregar(@RequestBody ItemCarrito item) {
        carritoService.agregarItem(item);
        return "Producto agregado";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        carritoService.eliminarItem(id);
        return "Producto eliminado";
    }

    @DeleteMapping("/vaciar")
    public String vaciar() {
        carritoService.vaciarCarrito();
        return "Carrito vacío";
    }
}