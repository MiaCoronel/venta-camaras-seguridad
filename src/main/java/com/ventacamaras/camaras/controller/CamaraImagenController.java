package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.CamaraImagen;
import com.ventacamaras.camaras.service.CamaraImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camaras")
@RequiredArgsConstructor
public class CamaraImagenController {

    private final CamaraImagenService imagenService;

    @PostMapping("/{camaraId}/imagenes")
    public ResponseEntity<CamaraImagen> agregarImagen(@PathVariable Long camaraId,
                                                       @RequestBody CamaraImagen imagen) {
        CamaraImagen nueva = imagenService.agregarImagen(camaraId, imagen);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping("/{camaraId}/imagenes")
    public ResponseEntity<List<CamaraImagen>> listarImagenes(@PathVariable Long camaraId) {
        List<CamaraImagen> imagenes = imagenService.listarPorCamara(camaraId);
        return ResponseEntity.ok(imagenes);
    }

    @GetMapping("/{camaraId}/imagenes/principal")
    public ResponseEntity<CamaraImagen> obtenerPrincipal(@PathVariable Long camaraId) {
        Optional<CamaraImagen> imagen = imagenService.obtenerPrincipal(camaraId);
        return imagen.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/imagenes/{id}")
    public ResponseEntity<Void> eliminarImagen(@PathVariable Long id) {
        imagenService.eliminarImagen(id);
        return ResponseEntity.noContent().build();
    }
}
