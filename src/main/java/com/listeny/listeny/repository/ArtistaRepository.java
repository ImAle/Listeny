package com.listeny.listeny.repository;

import com.listeny.listeny.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, String> {

}
