import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private ProductoRepository productoRepository; 
    private UsuarioRepository usuarioRepository;   

    @Transactional
    public Resena crearResena(Long productoId, String emailUsuario, Integer calificacion, String comentario) {
        
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

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

    @Transactional(readOnly = true) 
    public Double obtenerPromedio(Long productoId) {
        Double promedio = resenaRepository.obtenerPromedioCalificacionPorProducto(productoId);
        return promedio != null ? promedio : 0.0;
    }
}