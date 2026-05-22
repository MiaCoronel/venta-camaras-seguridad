package com.ventacamaras.camaras.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ordenes")
public class Orden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // <-- CAMBIADO A Integer

    @Column(nullable = false)
    private String cliente;
    
    @Column(nullable = false)
    private String producto;
    
    @Column(nullable = false)
    private Integer cantidad; // <-- CAMBIADO A Integer

    public Orden() {}

    public Orden(Integer id, String cliente, String producto, Integer cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}