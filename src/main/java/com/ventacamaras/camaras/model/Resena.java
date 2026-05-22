package com.ventacamaras.camaras.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resenas")
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 500)
    private String comentario;
    
    @Column(nullable = false)
    private Integer calificacion;
    
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId; 
    
    @Column(name = "camara_id", nullable = false)
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