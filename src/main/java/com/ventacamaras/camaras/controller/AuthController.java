package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.ventacamaras.camaras.dto.AuthResponse;
import com.ventacamaras.camaras.dto.LoginRequest;
import com.ventacamaras.camaras.dto.RegisterRequest;
import com.ventacamaras.camaras.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<User> me(Authentication authentication) {

        return ResponseEntity.ok(
                authService.getByUsername(authentication.getName())
        );

    }
}

