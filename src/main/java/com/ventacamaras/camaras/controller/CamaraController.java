package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.Camara;
import com.ventacamaras.camaras.service.CamaraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/camaras")
public class CamaraController {

    private final CamaraService camaraService;

    public CamaraController(CamaraService camaraService) {
        this.camaraService = camaraService;
    }

    @GetMapping
    public List<Camara> listarTodas() {
        return camaraService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camara> obtenerPorId(@PathVariable Long id) {
        return camaraService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Camara> crear(@RequestBody Camara camara) {
        Camara nueva = camaraService.guardar(camara);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camara> actualizar(@PathVariable Long id, @RequestBody Camara camara) {
        Camara actualizada = camaraService.actualizar(id, camara);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (camaraService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
