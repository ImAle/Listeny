package com.listeny.listeny.repository;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Reproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReproduccionRepository extends JpaRepository<Reproduccion, Long> {
    @Query("select r.cancion from Reproduccion r where r.usuario.id=:id ORDER BY r.fechaLastReproducciones desc")
    public List<Cancion> getUltimasCanciones (Long id);
}
