package com.ventacamaras.camaras.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ventacamaras.camaras.dto.AuthResponse;
import com.ventacamaras.camaras.dto.LoginRequest;
import com.ventacamaras.camaras.dto.RegisterRequest;
import com.ventacamaras.camaras.model.Role;
import com.ventacamaras.camaras.model.User;
import com.ventacamaras.camaras.repository.RoleRepository;
import com.ventacamaras.camaras.repository.UserRepository;
import com.ventacamaras.camaras.security.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Registra un nuevo usuario
     */
    public AuthResponse register(RegisterRequest request) {
        // Validar que el usuario no exista
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("El usuario ya existe");
        }

        // Obtener o crear rol por defecto
        Role roleCliente = roleRepository.findByName("CLIENTE")
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName("CLIENTE");
                    return roleRepository.save(newRole);
                });

        // Crear nuevo usuario
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .build();

        // Asignar rol al usuario
        user.getRoles().add(roleCliente);

        // Guardar usuario
        userRepository.save(user);

        // Generar token JWT
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    /**
     * Autentica un usuario existente
     */
    public AuthResponse login(LoginRequest request) {
        // Autenticar usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // Obtener usuario
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Generar token JWT
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }
}


