package com.ventacamaras.camaras.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ventacamaras.camaras.model.Cliente;
import com.ventacamaras.camaras.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService servicio;

    public ClienteController(ClienteService servicio) {
        this.servicio = servicio;
    }

    // GET: Listar todos los clientes
    @GetMapping
    public List<Cliente> listar() {
        return servicio.listar();
    }

    // GET: Obtener un cliente por su ID mapeando la respuesta a un estado HTTP
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Crear un nuevo cliente
    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return servicio.guardar(cliente);
    }

    // PUT: Actualizar un cliente existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return servicio.actualizar(id, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Eliminar un cliente de la base de datos por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        boolean eliminado = servicio.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build(); // Estado 204 sin contenido
        }
        return ResponseEntity.notFound().build(); // Estado 404 si el ID no existe
    }
}