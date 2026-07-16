package com.ventacamaras.camaras.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResenaDTO {
    private Integer calificacion;
    private String comentario;
}