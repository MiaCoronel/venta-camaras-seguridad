package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Pago;
import com.ventacamaras.camaras.repository.PagoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public Pago registrarPago(double monto, String metodo, Integer ordenId, String estado) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        // Pasamos null en el ID para que la base de datos asigne el autoincremental
        Pago pago = new Pago(null, monto, metodo, estado, ordenId);
        return pagoRepository.save(pago);
    }

    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    public List<Pago> pagosPorOrden(Integer ordenId) {
        return pagoRepository.findByOrdenId(ordenId);
    }

    public Optional<Pago> obtenerPorId(Integer pagoId) {
        return pagoRepository.findById(pagoId);
    }

    public List<Pago> pagosPorEstado(String estado) {
        return pagoRepository.findByEstado(estado);
    }

    public boolean cambiarEstado(Integer pagoId, String nuevoEstado) {
        Optional<Pago> pagoOpt = pagoRepository.findById(pagoId);
        if (pagoOpt.isPresent()) {
            Pago pago = pagoOpt.get();
            pago.setEstado(nuevoEstado);
            pagoRepository.save(pago);
            return true;
        }
        return false;
    }
}