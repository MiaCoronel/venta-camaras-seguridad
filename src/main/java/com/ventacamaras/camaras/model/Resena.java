package com.ventacamaras.camaras.model;

public class Resena {
    private Long id;
    private String comentario;
    private Integer calificacion;
    private Long clienteId; 
    private Long camaraId;  
    public Resena() {}

    public Resena(Long id, String comentario, Integer calificacion, Long clienteId, Long camaraId) {
        this.id = id;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.clienteId = clienteId;
        this.camaraId = camaraId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getCamaraId() { return camaraId; }
    public void setCamaraId(Long camaraId) { this.camaraId = camaraId; }
}
