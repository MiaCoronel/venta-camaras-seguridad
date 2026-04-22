package com.ventacamaras.camaras.service;
import org.springframework.stereotype.Service;
import java.util.*;

import com.ventacamaras.camaras.model.Orden;

@Service
public class OrdenService {

    private List<Orden> lista = new ArrayList<>();

    public OrdenService() {
        lista.add(new Orden(1, "Kiara", "Cámara Canon", 2));
        lista.add(new Orden(2, "Luis", "Cámara Sony", 1));
    }

    // Listar todas las órdenes
    public List<Orden> listar() {
        return lista;
    }

    // Obtener por ID
    public Orden obtenerPorId(int id) {
        return lista.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Agregar nueva orden
    public void agregar(Orden orden) {
        lista.add(orden);
    }
}
