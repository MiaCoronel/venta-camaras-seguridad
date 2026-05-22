package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.Pago;
import com.ventacamaras.camaras.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.listarPagos();
    }

    @GetMapping("/{pagoId}")
    public ResponseEntity<Pago> obtenerPago(@PathVariable Integer pagoId) {
        return pagoService.obtenerPorId(pagoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/orden/{ordenId}")
    public List<Pago> pagosPorOrden(@PathVariable Integer ordenId) {
        return pagoService.pagosPorOrden(ordenId);
    }

    @GetMapping("/estado/{estado}")
    public List<Pago> pagosPorEstado(@PathVariable String estado) {
        return pagoService.pagosPorEstado(estado);
    }

    @PostMapping
    public ResponseEntity<Pago> procesarPago(@RequestParam double monto,
                                             @RequestParam String metodo,
                                             @RequestParam Integer ordenId,
                                             @RequestParam String estado) {
        try {
            Pago nuevoPago = pagoService.registrarPago(monto, metodo, ordenId, estado);
            return ResponseEntity.ok(nuevoPago);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{pagoId}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable Integer pagoId,
                                              @RequestParam String nuevoEstado) {
        boolean cambiado = pagoService.cambiarEstado(pagoId, nuevoEstado);
        if (cambiado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}