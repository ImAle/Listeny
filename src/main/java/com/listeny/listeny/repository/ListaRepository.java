package com.listeny.listeny.repository;

import com.listeny.listeny.models.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {

}
