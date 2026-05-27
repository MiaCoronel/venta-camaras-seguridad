package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Camara;
import com.ventacamaras.camaras.model.CamaraImagen;
import com.ventacamaras.camaras.repository.CamaraImagenRepository;
import com.ventacamaras.camaras.repository.CamaraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CamaraImagenService {

    private final CamaraImagenRepository imagenRepository;
    private final CamaraRepository camaraRepository;

    public List<CamaraImagen> listarPorCamara(Long camaraId) {
        return imagenRepository.findByCamaraIdOrderByNumImagenAsc(camaraId);
    }

    public Optional<CamaraImagen> obtenerPrincipal(Long camaraId) {
        return imagenRepository.buscarImagenPrincipal(camaraId);
    }

    @Transactional
    public CamaraImagen agregarImagen(Long camaraId, CamaraImagen imagen) {
        Camara camara = camaraRepository.findById(camaraId)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada con id: " + camaraId));
        imagen.setCamara(camara);
        return imagenRepository.save(imagen);
    }

    public void eliminarImagen(Long id) {
        imagenRepository.deleteById(id);
    }
}
