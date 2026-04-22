package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Camara;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CamaraService {
    
    private List<Camara> camaras = new ArrayList<>();
    private Long siguienteId = 1L;

    public CamaraService() {
        camaras.add(new Camara(siguienteId++, "Camara Dome 4K", "4K", "Dome", 129.99, 10));
        camaras.add(new Camara(siguienteId++, "Camara Bullet 1080p", "1080p", "Bullet", 79.99, 15));
        camaras.add(new Camara(siguienteId++, "Camara PTZ 2K", "2K", "PTZ", 249.99, 5));
    }

    public List<Camara> obtenerTodas() {
        return camaras;
    }

    public Optional<Camara> obtenerPorId(Long id) {
        return camaras.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Camara guardar(Camara camara) {
        camara.setId(siguienteId++);
        camaras.add(camara);
        return camara;
    }

    public Camara actualizar(Long id, Camara camaraActualizada) {
        Optional<Camara> existente = obtenerPorId(id);
        if (existente.isPresent()) {
            Camara camara = existente.get();
            camara.setNombre(camaraActualizada.getNombre());
            camara.setResolucion(camaraActualizada.getResolucion());
            camara.setTipo(camaraActualizada.getTipo());
            camara.setPrecio(camaraActualizada.getPrecio());
            camara.setStock(camaraActualizada.getStock());
            return camara;
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return camaras.removeIf(c -> c.getId().equals(id));
    }
}
