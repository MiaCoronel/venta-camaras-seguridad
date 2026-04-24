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
                "La cámara MagikMini tiene excelente calidad de imagen y video.",
                5,
                101L,
                1L));

        resenas.add(new Resena(2L,
                "La cámara 1080p es accesible, pero tiene limitaciones de acercamiento.",
                3,
                105L,
                23L));

        resenas.add(new Resena(3L,
                "Desconforme, el producto se averio a la semana de comprarlo, no me dieron solucion.",
                1,
                106L,
                12L));
               
        resenas.add(new Resena(4L,
                "Buen producto, pero mal soporte al momento de adquirir el producto",
                3,
                109L,
                10L));        
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
