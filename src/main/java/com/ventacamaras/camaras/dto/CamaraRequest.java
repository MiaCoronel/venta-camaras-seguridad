package com.ventacamaras.camaras.dto;

import lombok.Data;

@Data
public class CamaraRequest {
    private String nombre;
    private String marca;
    private String modelo;
    private String resolucion;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Long categoriaId;
}
