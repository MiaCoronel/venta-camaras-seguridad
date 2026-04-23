package com.ventacamaras.camaras.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pago {
    private int id;
    private double monto;
    private String metodo;
    private String estado;
    private int ordenId;
}