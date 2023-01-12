package com.listeny.listeny.repository;

import com.listeny.listeny.models.Canciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionesRepository extends JpaRepository<Canciones, Integer> {

}
