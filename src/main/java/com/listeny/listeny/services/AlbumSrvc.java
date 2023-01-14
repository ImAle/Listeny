package com.listeny.listeny.services;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumSrvc {

    private final AlbumRepository albrep;

    public AlbumSrvc(AlbumRepository albumRepository) {
        this.albrep = albumRepository;
    }

    public List<Album> getAlbumes() {
        return albrep.listAll();
    }
}
