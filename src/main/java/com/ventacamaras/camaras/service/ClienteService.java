package com.ventacamaras.camaras.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ventacamaras.camaras.model.Cliente;

@Service
public class ClienteService {
    private List<Cliente> lista= new ArrayList<>();
    public ClienteService(){
        lista.add(new Cliente(1,"Pedro Garcia", "PedroG@gmail.com"));
        lista.add(new Cliente(2, "Gabriela Perez", "GabPe@gmail.com"));
        lista.add(new Cliente(3, "Omar Gonzales", "OmarGon@gmail.com"));
    }

    public List<Cliente> listar(){
        return lista;
    }

    public Cliente obtenerPorId(int id){
        return lista.stream()
        .filter(c -> c.getId()== id)
        .findFirst()
        .orElse(null);
    }

}
