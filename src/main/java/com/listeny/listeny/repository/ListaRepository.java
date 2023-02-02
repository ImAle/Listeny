package com.listeny.listeny.repository;

import com.listeny.listeny.models.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {

    @Query("SELECT l FROM Lista l WHERE l.nombre LIKE :nombre")
    public List<Lista> findByNombreContaining(@Param("nombre") String nombre);
}
