package com.ventacamaras.camaras.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private Long userId;
}
