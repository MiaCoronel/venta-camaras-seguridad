package com.ventacamaras.camaras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagos")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Cambiado a Integer para permitir nulos en la creación
    
    @Column(nullable = false)
    private double monto;
    
    @Column(nullable = false, length = 50)
    private String metodo;
    
    @Column(nullable = false, length = 50)
    private String estado;
    
    @Column(name = "orden_id", nullable = false)
    private Integer ordenId; // Cambiado a Integer por consistencia con la entidad Orden
}