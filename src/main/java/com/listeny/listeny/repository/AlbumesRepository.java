package com.listeny.listeny.repository;

import com.listeny.listeny.models.Albumes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumesRepository extends JpaRepository <Albumes, Integer> {

}
