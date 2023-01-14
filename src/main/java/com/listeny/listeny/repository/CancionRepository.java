package com.listeny.listeny.repository;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {

    @Query("select c from Cancion c")
    List<Cancion> listAll();
}
