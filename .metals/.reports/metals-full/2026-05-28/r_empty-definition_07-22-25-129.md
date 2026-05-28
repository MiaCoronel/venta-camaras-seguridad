error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.3/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ResenaService.java:_empty_/ResenaRepository#findByCamaraIdAndCalificacionGreaterThanEqual#
file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.3/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ResenaService.java
empty definition using pc, found symbol in pc: _empty_/ResenaRepository#findByCamaraIdAndCalificacionGreaterThanEqual#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2446
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.3/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/service/ResenaService.java
text:
```scala
package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Camara;
import com.ventacamaras.camaras.model.Cliente;
import com.ventacamaras.camaras.model.Resena;
import com.ventacamaras.camaras.repository.CamaraRepository;
import com.ventacamaras.camaras.repository.ClienteRepository;
import com.ventacamaras.camaras.repository.ResenaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResenaService {

    private final ResenaRepository resenaRepository;
    private final CamaraRepository camaraRepository;
    private final ClienteRepository clienteRepository;

    @Transactional
    public Resena crearResena(Long camaraId, String emailUsuario,
                               Integer calificacion, String comentario) {

        Cliente cliente = clienteRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con email: " + emailUsuario));

        Camara camara = camaraRepository.findById(camaraId)
                .orElseThrow(() -> new RuntimeException("Cámara no encontrada con id: " + camaraId));

        if (calificacion < 1 || calificacion > 5) {
            throw new RuntimeException("La calificación debe estar entre 1 y 5");
        }

        if (resenaRepository.existeResenaDeClienteEnCamara(camaraId, cliente.getId())) {
            throw new RuntimeException("El cliente ya dejó una reseña para esta cámara");
        }

        Resena resena = Resena.builder()
                .camara(camara)
                .cliente(cliente)
                .calificacion(calificacion)
                .comentario(comentario)
                .build();

        return resenaRepository.save(resena);
    }

    @Transactional(readOnly = true)
    public List<Resena> listarPorCamara(Long camaraId) {
        return resenaRepository.findByCamaraId(camaraId);
    }

    @Transactional(readOnly = true)
    public Optional<Resena> obtenerPorId(Long id) {
        return resenaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Resena> listarPorCalificacionMinima(Long camaraId, Integer minCalificacion) {
        return resenaRepository.findByCamaraIdAnd@@CalificacionGreaterThanEqual(camaraId, minCalificacion);
    }

    @Transactional(readOnly = true)
    public Double obtenerPromedio(Long camaraId) {
        Double promedio = resenaRepository.obtenerPromedioCalificacion(camaraId);
        return promedio != null ? promedio : 0.0;
    }

    @Transactional
    public void eliminarResena(Long id) {
        resenaRepository.deleteById(id);
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/ResenaRepository#findByCamaraIdAndCalificacionGreaterThanEqual#