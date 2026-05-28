package com.ventacamaras.camaras.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ventacamaras.camaras.service.OrdenService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ordenes")
public class OrdenController {


    private final OrdenService ordenService;

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(
            Authentication auth,
            @RequestParam String metodo){

        String username = auth.getName();

        return ResponseEntity.ok(
            ordenService.checkout(
                username,
                metodo
            )
        );
    }
}