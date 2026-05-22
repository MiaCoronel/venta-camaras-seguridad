package com.ventacamaras.camaras.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ventacamaras.camaras.model.Camara;
public interface CamaraRepository extends JpaRepository<Camara,Long>{
    
}
