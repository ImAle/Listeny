package com.listeny.listeny.repository;

import com.listeny.listeny.models.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {

    @Query("SELECT c FROM Cancion c WHERE c.titulo LIKE :titulo")
    public List<Cancion> findByTituloContaining(@Param("titulo") String titulo);
}
