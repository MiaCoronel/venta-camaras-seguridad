package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Camara;
import com.ventacamaras.camaras.repository.CamaraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CamaraService {

    private final CamaraRepository camaraRepository;

    public List<Camara> listarCamaras() {
        return camaraRepository.findAll();
    }

    public Optional<Camara> obtenerPorId(Long id) {
        return camaraRepository.findById(id);
    }

    public List<Camara> buscarPorMarca(String marca) {
        return camaraRepository.findByMarca(marca);
    }

    public List<Camara> buscarPorNombre(String nombre) {
        return camaraRepository.buscarPorNombre(nombre);
    }

    public List<Camara> buscarPorRangoPrecio(Double min, Double max) {
        return camaraRepository.findByPrecioBetween(min, max);
    }

    public List<Camara> buscarDisponiblesPorMarca(String marca) {
        return camaraRepository.buscarDisponiblesPorMarca(marca);
    }

    public List<Camara> buscarConStock() {
        return camaraRepository.findByStockGreaterThan(0);
    }

    public Camara crearCamara(Camara camara) {
        return camaraRepository.save(camara);
    }

    public Camara actualizarCamara(Long id, Camara camaraActualizada) {
        Camara camara = camaraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada con id: " + id));
        camara.setNombre(camaraActualizada.getNombre());
        camara.setMarca(camaraActualizada.getMarca());
        camara.setModelo(camaraActualizada.getModelo());
        camara.setResolucion(camaraActualizada.getResolucion());
        camara.setPrecio(camaraActualizada.getPrecio());
        camara.setStock(camaraActualizada.getStock());
        return camaraRepository.save(camara);
    }

    public void eliminarCamara(Long id) {
        camaraRepository.deleteById(id);
    }

    @Transactional
    public Camara actualizarPrecio(Long id, Double nuevoPrecio) {
        Camara camara = camaraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada con id: " + id));
        camara.setPrecio(nuevoPrecio);
        return camaraRepository.save(camara);
    }

    @Transactional
    public void descontarStock(Long id, Integer cantidad) {
        Camara camara = camaraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada con id: " + id));
        if (camara.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente. Stock actual: " + camara.getStock());
        }
        camara.setStock(camara.getStock() - cantidad);
        camaraRepository.save(camara);
    }

    @Transactional
    public void simularErrorTransaccional(Long id) {
        Camara camara = camaraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada con id: " + id));
        camara.setPrecio(camara.getPrecio() + 100);
        camaraRepository.save(camara);
        throw new RuntimeException("Error simulado: la transacción debe revertirse (rollback)");
    }
}
