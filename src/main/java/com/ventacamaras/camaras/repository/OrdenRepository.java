package com.ventacamaras.camaras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ventacamaras.camaras.model.Orden;

@Repository
public interface OrdenRepository
extends JpaRepository<Orden,Integer>{

    @Query("""
        SELECT o
        FROM Orden o
        WHERE o.estado = :estado
    """)
    List<Orden> buscarPorEstado(
        @Param("estado") String estado
    );

}
