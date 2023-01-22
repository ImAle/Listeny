package com.listeny.listeny.repository;

import com.listeny.listeny.models.Album;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository <Album, Long> {

    @Query("select al from Album al")
    List<Album> listAll();
}
