package com.ventacamaras.camaras.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // pagos.orden_id → ordenes.id (unique: 1 pago por orden)
    @Column(name = "orden_id", nullable = false, unique = true)
    private Integer ordenId;

    @Column(nullable = false)
    private Double monto;

    // BD: metodo VARCHAR(50)
    @Column(nullable = false, length = 50)
    private String metodo;

    // BD: estado VARCHAR(50) DEFAULT 'PENDIENTE'
    @Column(nullable = false, length = 50)
    private String estado = "PENDIENTE";
}
