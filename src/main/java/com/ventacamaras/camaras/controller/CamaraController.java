package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.Camara;
import com.ventacamaras.camaras.service.CamaraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camaras")
@RequiredArgsConstructor
public class CamaraController {

    private final CamaraService camaraService;

    @PostMapping
    public ResponseEntity<Camara> crearCamara(@RequestBody Camara camara) {
        Camara camaraCreada = camaraService.crearCamara(camara);
        return ResponseEntity.ok(camaraCreada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camara> obtenerCamara(@PathVariable Long id) {
        Optional<Camara> camara = camaraService.obtenerPorId(id);
        return camara.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Camara>> listarCamaras() {
        List<Camara> camaras = camaraService.listarCamaras();
        return ResponseEntity.ok(camaras);
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Camara>> buscarPorMarca(@PathVariable String marca) {
        List<Camara> camaras = camaraService.buscarPorMarca(marca);
        return ResponseEntity.ok(camaras);
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<Camara>> buscarPorNombre(@RequestParam String nombre) {
        List<Camara> camaras = camaraService.buscarPorNombre(nombre);
        return ResponseEntity.ok(camaras);
    }

    @GetMapping("/buscar/rango-precio")
    public ResponseEntity<List<Camara>> buscarPorRangoPrecio(@RequestParam Double min,
                                                              @RequestParam Double max) {
        List<Camara> camaras = camaraService.buscarPorRangoPrecio(min, max);
        return ResponseEntity.ok(camaras);
    }

    @GetMapping("/disponibles/{marca}")
    public ResponseEntity<List<Camara>> buscarDisponiblesPorMarca(@PathVariable String marca) {
        List<Camara> camaras = camaraService.buscarDisponiblesPorMarca(marca);
        return ResponseEntity.ok(camaras);
    }

    @GetMapping("/con-stock")
    public ResponseEntity<List<Camara>> buscarConStock() {
        List<Camara> camaras = camaraService.buscarConStock();
        return ResponseEntity.ok(camaras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camara> actualizarCamara(@PathVariable Long id,
                                                    @RequestBody Camara camaraActualizada) {
        Camara camara = camaraService.actualizarCamara(id, camaraActualizada);
        return ResponseEntity.ok(camara);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCamara(@PathVariable Long id) {
        camaraService.eliminarCamara(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/precio")
    public ResponseEntity<Camara> actualizarPrecio(@PathVariable Long id,
                                                    @RequestParam Double nuevoPrecio) {
        Camara camara = camaraService.actualizarPrecio(id, nuevoPrecio);
        return ResponseEntity.ok(camara);
    }

    @PutMapping("/{id}/descontar-stock")
    public ResponseEntity<String> descontarStock(@PathVariable Long id,
                                                  @RequestParam Integer cantidad) {
        camaraService.descontarStock(id, cantidad);
        return ResponseEntity.ok("Stock descontado correctamente");
    }

    @PutMapping("/{id}/simular-error")
    public ResponseEntity<String> simularError(@PathVariable Long id) {
        camaraService.simularErrorTransaccional(id);
        return ResponseEntity.ok().build();
    }
}
