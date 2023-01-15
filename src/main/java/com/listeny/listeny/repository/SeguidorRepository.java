package com.listeny.listeny.repository;

import com.listeny.listeny.models.Seguidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguidorRepository extends JpaRepository<Seguidor, Long> {

}
