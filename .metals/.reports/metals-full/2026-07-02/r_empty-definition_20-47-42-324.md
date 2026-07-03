error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ClienteService.java:com/ventacamaras/camaras/model/User#
file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ClienteService.java
empty definition using pc, found symbol in pc: com/ventacamaras/camaras/model/User#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 298
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ClienteService.java
text:
```scala
package com.ventacamaras.camaras.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ventacamaras.camaras.dto.ClienteRequest;
import com.ventacamaras.camaras.model.Cliente;
import com.ventacamaras.camaras.model.@@User;
import com.ventacamaras.camaras.repository.ClienteRepository;
import com.ventacamaras.camaras.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final UserRepository userRepository;

    /**
     * Crear un nuevo cliente
     */
    public Cliente crearCliente(ClienteRequest clienteRequest) {
        if (clienteRepository.findByEmail(clienteRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        if (clienteRequest.getUserId() == null) {
            throw new IllegalArgumentException("El cliente necesita un userId");
        }

        User user = userRepository.findById(clienteRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Cliente cliente = Cliente.builder()
                .nombre(clienteRequest.getNombre())
                .email(clienteRequest.getEmail())
                .direccion(clienteRequest.getDireccion())
                .telefono(clienteRequest.getTelefono())
                .user(user)
                .build();

        return clienteRepository.save(cliente);
    }


    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }


    public Optional<Cliente> obtenerPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }


    public Optional<Cliente> obtenerPorUserId(Long userId) {
        return clienteRepository.findByUserId(userId);
    }

    /**
     * Buscar clientes por nombre (con query personalizado)
     */
    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepository.buscarPorNombre(nombre);
    }

    /**
     * Buscar cliente por teléfono (con query personalizado)
     */
    public Optional<Cliente> buscarPorTelefono(String telefono) {
        return clienteRepository.buscarPorTelefono(telefono);
    }


    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setEmail(clienteActualizado.getEmail());
        cliente.setDireccion(clienteActualizado.getDireccion());
        cliente.setTelefono(clienteActualizado.getTelefono());

        return clienteRepository.save(cliente);
    }

    /**
     * Eliminar cliente y deshabilitar su usuario asociado
     * Transacción para garantizar integridad: si falla algo, se revierte todo
     */
    @Transactional
    public void eliminarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // Obtener el usuario asociado al cliente
        Long userId = cliente.getUser().getId();

        // Deshabilitar el usuario
        userRepository.findById(userId).ifPresent(user -> {
            user.setEnabled(false);
            userRepository.save(user);
        });

        // Eliminar el cliente
        clienteRepository.deleteById(id);
    }
}


```


#### Short summary: 

empty definition using pc, found symbol in pc: com/ventacamaras/camaras/model/User#