error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ClienteService.java
file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ClienteService.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[21,14]

error in qdox parser
file content:
```java
offset: 662
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ClienteService.java
text:
```scala
package com.ventacamaras.camaras.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ventacamaras.camaras.model.Cliente;
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
    src/main/j@@ava/com/ventacamaras/camaras/service/ClienteService.java


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

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1570)
```
#### Short summary: 

QDox parse error in file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ClienteService.java