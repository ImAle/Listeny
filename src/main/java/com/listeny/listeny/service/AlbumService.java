package com.listeny.listeny.service;

import com.google.common.collect.Lists;
import com.listeny.listeny.Dto.AlbumDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.repository.AlbumRepository;
import com.listeny.listeny.repository.ListaRepository;
import com.listeny.listeny.service.mapper.AlbumMapper;
import javafx.stage.Stage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService extends AbstractBusinessService<Album, Long, AlbumDto, AlbumRepository, AlbumMapper>{

    StreamingService streamingService;
    private final ListaRepository listaRepository;

    public AlbumService(AlbumRepository repo, AlbumMapper mapper, ListaRepository listaRepository) {
        super(repo, mapper);
        this.listaRepository = listaRepository;
    }


    public Album getAlbumById(@PathVariable("id") Long id) throws Exception {
        Optional<Album> album = getRepo().findById(id);
        if (album.isPresent()){
            return album.get();
        }
        throw new Exception("El álbum no existe");
    }

    public void cambiarEstadoPublico (Long idAlbum) throws Exception {
        Album album = getAlbumById(idAlbum);
        if(album.getPublico()){
            album.setPublico(false);
        }else{
            album.setPublico(true);
        }
        getRepo().save(album);
    }

    public List<Album> getAlbumesRecomendados(){
        List<Album> albumesAPantalla = new ArrayList<>();
        for (Long id: getElementoAzarId(5)) {
            Optional<Album> album = getRepo().findById(id);
            album.ifPresent(albumesAPantalla::add);
        }
        return albumesAPantalla;
    }

    public Long copyAlbumALista(Long idListaACopiar, String nombre, Usuario esteUsuario, Categoria categoria) throws Exception {
        Album albumACopiar = getAlbumById(idListaACopiar);
        Lista lista = new Lista();
        lista.setNombre(nombre);
        lista.setPropietarioLista(esteUsuario);
        lista.setListasCategoria(categoria);
        lista.setCancionesLista(albumACopiar.getCancionesAlbum());
        listaRepository.save(lista);
        return lista.getId();
    }

    public Long copyAlbumAAlbum(Long idAlbumACopiar, String nombre, Usuario esteUsuario) throws Exception {
        Album albumACopiar = getAlbumById(idAlbumACopiar);
        Album album = new Album();
        album.setTitulo(nombre);
        album.setPropietarioAlbum(esteUsuario);
        album.setCancionesAlbum(albumACopiar.getCancionesAlbum());
        getRepo().save(album);
        return album.getId();
    }

    public List<Album> getAlbumesMasReproducidos (){
        List<Album> masReproducidas = Lists.newArrayList(getRepo().albumesMasReproducidos());
        List<List<Album>> particionEnCinco = Lists.partition(masReproducidas, 5);

        return particionEnCinco.get(1);
    }

    public void reproducirAlbum (Album album){
        streamingService.setCanciones(album.getCancionesAlbum());
        streamingService.start(new Stage());
    }

}
