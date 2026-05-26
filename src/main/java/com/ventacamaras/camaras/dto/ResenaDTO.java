package com.ventacamaras.camaras.dto;

public class ResenaDTO {
    private Integer calificacion;
    private String comentario;

    // --- ESTOS SON LOS MÉTODOS QUE EL CONTROLADOR NO ENCUENTRA ---
    public Integer getCalificacion() { 
        return calificacion; 
    }
    
    public void setCalificacion(Integer calificacion) { 
        this.calificacion = calificacion; 
    }
    
    public String getComentario() { 
        return comentario; 
    }
    
    public void setComentario(String comentario) { 
        this.comentario = comentario; 
    }
}