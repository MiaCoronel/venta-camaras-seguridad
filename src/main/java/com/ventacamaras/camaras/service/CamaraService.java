package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Camara;
import com.ventacamaras.camaras.repository.CamaraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamaraService {
    
    private final CamaraRepository camaraRepository;

    // Inyectamos el repositorio a través del constructor
    public CamaraService(CamaraRepository camaraRepository) {
        this.camaraRepository = camaraRepository;
    }

    public List<Camara> obtenerTodas() {
        return camaraRepository.findAll();
    }

    public Optional<Camara> obtenerPorId(Long id) {
        return camaraRepository.findById(id);
    }

    public Camara guardar(Camara camara) {
        // JPA asignará el ID automáticamente y lo guardará en MySQL
        return camaraRepository.save(camara);
    }

    public Camara actualizar(Long id, Camara camaraActualizada) {
        Optional<Camara> existente = camaraRepository.findById(id);
        
        if (existente.isPresent()) {
            Camara camara = existente.get();
            camara.setNombre(camaraActualizada.getNombre());
            camara.setResolucion(camaraActualizada.getResolucion());
            camara.setTipo(camaraActualizada.getTipo());
            camara.setPrecio(camaraActualizada.getPrecio());
            camara.setStock(camaraActualizada.getStock());
            
            // save() actúa como UPDATE si el objeto ya tiene un ID existente en la BD
            return camaraRepository.save(camara);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (camaraRepository.existsById(id)) {
            camaraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}