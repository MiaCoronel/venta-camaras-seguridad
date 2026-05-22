package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Resena;
import com.ventacamaras.camaras.repository.ResenaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {

    private final ResenaRepository resenaRepository;

    public ResenaService(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    public List<Resena> obtenerTodas() {
        return resenaRepository.findAll();
    }

    public Optional<Resena> obtenerPorId(Long id) {
        return resenaRepository.findById(id);
    }

    public Resena guardar(Resena resena) {
        return resenaRepository.save(resena);
    }

    public Resena actualizar(Long id, Resena resenaActualizada) {
        Optional<Resena> existente = resenaRepository.findById(id);
        if (existente.isPresent()) {
            Resena r = existente.get();
            r.setComentario(resenaActualizada.getComentario());
            r.setCalificacion(resenaActualizada.getCalificacion());
            r.setClienteId(resenaActualizada.getClienteId());
            r.setCamaraId(resenaActualizada.getCamaraId());
            return resenaRepository.save(r);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (resenaRepository.existsById(id)) {
            resenaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}