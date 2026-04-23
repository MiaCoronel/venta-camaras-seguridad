package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.Pago;
import com.ventacamaras.camaras.service.PagoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Pago> obtenerPago(@PathVariable int pagoId) {
        return pagoService.obtenerPorId(pagoId);
    }

    @GetMapping("/orden/{ordenId}")
    public List<Pago> pagosPorOrden(@PathVariable int ordenId) {
        return pagoService.pagosPorOrden(ordenId);
    }

    @GetMapping("/estado/{estado}")
    public List<Pago> pagosPorEstado(@PathVariable String estado) {
        return pagoService.pagosPorEstado(estado);
    }

    @PostMapping
    public Pago procesarPago(@RequestParam double monto,
                            @RequestParam String metodo,
                            @RequestParam int ordenId,
                             @RequestParam String estado) {
        return pagoService.registrarPago(monto, metodo, ordenId, estado);
    }

    @PutMapping("/{pagoId}/estado")
    public boolean cambiarEstado(@PathVariable int pagoId,
                                 @RequestParam String nuevoEstado) {
        return pagoService.cambiarEstado(pagoId, nuevoEstado);
    }
}