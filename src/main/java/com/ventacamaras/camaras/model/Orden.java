package com.ventacamaras.camaras.model;


public class Orden {
    private int id;
    private String cliente;
    private String producto;
    private int cantidad;

    public Orden(int id, String cliente, String producto, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public String getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
}

