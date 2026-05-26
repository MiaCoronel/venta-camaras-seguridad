import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {

    List<Resena> findByProductoId(Long productoId);

    @Query("SELECT AVG(r.calificacion) FROM Resena r WHERE r.producto.id = :productoId")
    Double obtenerPromedioCalificacionPorProducto(@Param("productoId") Long productoId);

    @Query("SELECT COUNT(r) > 0 FROM Resena r WHERE r.producto.id = :productoId AND r.usuario.id = :usuarioId")
    boolean existeResenaDeUsuarioEnProducto(@Param("productoId") Long productoId, @Param("usuarioId") Long usuarioId);
}