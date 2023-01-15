package com.listeny.listeny.repository;

import com.listeny.listeny.models.Reproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReproduccionRepository extends JpaRepository<Reproduccion, Long> {

}
