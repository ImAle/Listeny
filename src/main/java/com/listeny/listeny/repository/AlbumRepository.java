package com.listeny.listeny.repository;

import com.listeny.listeny.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a ORDER BY a.reproducciones DESC")
    public List<Album> albumesMasReproducidos();

    @Query("SELECT a FROM Album a WHERE a.titulo LIKE :titulo")
    public List<Album> findByTituloContaining(@Param("titulo") String titulo);
}
