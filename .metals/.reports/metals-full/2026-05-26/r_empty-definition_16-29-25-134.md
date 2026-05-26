error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.1/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ResenaService.java:
file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.1/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ResenaService.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1030
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.1/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ResenaService.java
text:
```scala
package com.ventacamaras.camaras.service;

public class ResenaService {
    
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private ProductoRepository productoRepository; // Asumiendo que existe
    @Autowired
    private UsuarioRepository usuarioRepository;   // Asumiendo que existe

    // Uso de @Transactional: Asegura que la operación sea atómica
    @Transactional
    public Resena crearResena(Long productoId, String emailUsuario, Integer calificacion, String comentario) {
        
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                
        Producto producto = productoRepository.findById(productoI@@d)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Regla de negocio: Un usuario solo puede dejar una reseña por cámara
        if (resenaRepository.existeResenaDeUsuarioEnProducto(productoId, usuario.getId())) {
            throw new RuntimeException("El usuario ya dejó una reseña para este producto");
        }

        Resena nuevaResena = new Resena();
        nuevaResena.setProducto(producto);
        nuevaResena.setUsuario(usuario);
        nuevaResena.setCalificacion(calificacion);
        nuevaResena.setComentario(comentario);

        return resenaRepository.save(nuevaResena);
    }

    @Transactional(readOnly = true) // Optimiza consultas de solo lectura
    public Double obtenerPromedio(Long productoId) {
        Double promedio = resenaRepository.obtenerPromedioCalificacionPorProducto(productoId);
        return promedio != null ? promedio : 0.0;
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 