package com.ventacamaras.camaras.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.ventacamaras.camaras.model.Orden;
import com.ventacamaras.camaras.service.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final OrdenService servicio;

    public OrdenController(OrdenService servicio) {
        this.servicio = servicio;
    }

    // GET: listar todas las órdenes
    @GetMapping
    public List<Orden> listar() {
        return servicio.listar();
    }

    // GET: obtener por id
    @GetMapping("/{id}")
    public Orden obtener(@PathVariable int id) {
        return servicio.obtenerPorId(id);
    }

    // POST: crear nueva orden
    @PostMapping
    public void agregar(@RequestBody Orden orden) {
        servicio.agregar(orden);
    }
}