package com.ventacamaras.camaras.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.ventacamaras.camaras.model.Cliente;
import com.ventacamaras.camaras.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Inyección de dependencias por constructor
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Listar todos los clientes de la base de datos
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // Buscar un cliente por su ID utilizando Optional
    public Optional<Cliente> obtenerPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    // Guardar un nuevo cliente en MySQL
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar datos de un cliente existente
    public Optional<Cliente> actualizar(Integer id, Cliente datos) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(datos.getNombre());
            cliente.setEmail(datos.getEmail());
            return Optional.of(clienteRepository.save(cliente));
        }
        return Optional.empty();
    }

    // Eliminar un cliente si existe en la base de datos
    public boolean eliminar(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}