package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.Carrito;
import com.ventacamaras.camaras.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarAlCarrito(
            @RequestParam Long camaraId, 
            @RequestParam Integer cantidad) {
        
        try {
            // Se obtiene al usuario de la sesión actual (el token que envías en Postman)
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName(); 

            Carrito carritoActualizado = carritoService.agregarItemAlCarrito(username, camaraId, cantidad);
            
            return ResponseEntity.ok(carritoActualizado);
            
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}