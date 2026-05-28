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

    @OneToOne
    @JoinColumn(name = "orden_id", nullable = false, unique = true)
    private Orden orden;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false, length = 50)
    private String metodo;

    @Column(nullable = false, length = 50)
    private String estado = "PENDIENTE";
}
