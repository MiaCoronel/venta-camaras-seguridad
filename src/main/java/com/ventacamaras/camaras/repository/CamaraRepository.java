package com.ventacamaras.camaras.repository;

import com.ventacamaras.camaras.model.Camara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CamaraRepository extends JpaRepository<Camara, Long> {

    List<Camara> findByMarca(String marca);

    List<Camara> findByPrecioBetween(Double min, Double max);

    List<Camara> findByStockGreaterThan(Integer stock);

    @Query("SELECT c FROM Camara c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Camara> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT c FROM Camara c WHERE c.marca = :marca AND c.stock > 0")
    List<Camara> buscarDisponiblesPorMarca(@Param("marca") String marca);
}
