package com.ventacamaras.camaras.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ventacamaras.camaras.model.Cliente;


import com.ventacamaras.camaras.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService servicio;

    public ClienteController(ClienteService servicio){
        this.servicio= servicio;
    }

    @GetMapping
    public List<Cliente> listar(){
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable int id){
        return servicio.obtenerPorId(id);
    }
}
