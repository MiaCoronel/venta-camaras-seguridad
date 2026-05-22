package com.ventacamaras.camaras.repository;

import com.ventacamaras.camaras.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByOrdenId(Integer ordenId);
    List<Pago> findByEstado(String estado);
}