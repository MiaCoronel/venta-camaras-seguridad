package com.ventacamaras.camaras.controller;
import com.ventacamaras.camaras.service.ResenaService;
import com.ventacamaras.camaras.dto.ResenaDTO;
import com.ventacamaras.camaras.model.Resena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @PostMapping("/producto/{productoId}")
    public ResponseEntity<?> crearResena(@PathVariable Long productoId, @RequestBody ResenaDTO resenaRequest) {
        
        // Obtenemos el usuario autenticado desde el contexto de Spring Security (Extraído del JWT en tu filtro)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String emailUsuario = auth.getName(); // El username/email suele extraerse del token

        try {
            Resena resenaGuardada = resenaService.crearResena(
                productoId, 
                emailUsuario, 
                resenaRequest.getCalificacion(), 
                resenaRequest.getComentario()
            );
            return ResponseEntity.ok("Reseña creada con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ENDPOINT PÚBLICO: No requiere Token
    @GetMapping("/producto/{productoId}/promedio")
    public ResponseEntity<Double> obtenerPromedio(@PathVariable Long productoId) {
        return ResponseEntity.ok(resenaService.obtenerPromedio(productoId));
    }
}