package com.listeny.listeny.service;

import com.listeny.listeny.Dto.AlbumDto;
import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.repository.AlbumRepository;
import com.listeny.listeny.service.mapper.AlbumMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService extends AbstractBusinessService<Album, Long, AlbumDto, AlbumRepository, AlbumMapper>{

    public AlbumService(AlbumRepository repo, AlbumMapper mapper) {
        super(repo, mapper);
    }


    public Album getAlbumById(@PathVariable("id") Long id) throws Exception {
        Optional<Album> album = getRepo().findById(id);
        if (album.isPresent()){
            return album.get();
        }
        throw new Exception("El álbum no existe");
    }

    public List<Cancion> getCancionesDelAlbum(Long id) throws Exception {
        Optional<AlbumDto> album = getRepo().findById(id).map(getMapper()::toDto);
        if(album.isPresent()) {
            return album.get().getCancionesAlbum();
        }
        throw new Exception("El álbum no existe");
    }

//    public List<Album> getAlbumesRecomendados(){
//
//    }
}