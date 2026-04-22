package com.ventacamaras.camaras.model;

public class Camara {
    private Long id;
    private String nombre;
    private String resolucion;
    private String tipo;
    private Double precio;
    private Integer stock;

    public Camara() {}

    public Camara(Long id, String nombre, String resolucion, String tipo, Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.resolucion = resolucion;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getResolucion() { return resolucion; }
    public void setResolucion(String resolucion) { this.resolucion = resolucion; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
