package com.ventacamaras.camaras.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.ventacamaras.camaras.model.Orden;
import com.ventacamaras.camaras.repository.OrdenRepository;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> listar() {
        return ordenRepository.findAll();
    }

    public Orden obtenerPorId(int id) {
        return ordenRepository.findById(id).orElse(null);
    }

    public void agregar(Orden orden) {
        ordenRepository.save(orden);
    }
}