package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Resena;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {

    private final List<Resena> resenas = new ArrayList<>();

    public ResenaService() {
      
        resenas.add(new Resena(1L,
                "La cámara Dome 4K tiene excelente calidad de imagen y es ideal para vigilancia en interiores.",
                5,
                101L,
                1L));

        resenas.add(new Resena(2L,
                "La cámara Bullet 1080p es económica y cumple bien para exteriores, aunque el zoom es limitado.",
                4,
                102L,
                2L));
    }

    

    public List<Resena> obtenerTodas() {
        return resenas;
    }

    public Optional<Resena> obtenerPorId(Long id) {
        return resenas.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public Resena guardar(Resena resena) {
        resenas.add(resena);
        return resena;
    }

    public Resena actualizar(Long id, Resena resena) {
        Optional<Resena> existente = obtenerPorId(id);
        if (existente.isPresent()) {
            Resena r = existente.get();
            r.setComentario(resena.getComentario());
            r.setCalificacion(resena.getCalificacion());
            r.setClienteId(resena.getClienteId());
            r.setCamaraId(resena.getCamaraId());
            return r;
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return resenas.removeIf(r -> r.getId().equals(id));
    }
}
