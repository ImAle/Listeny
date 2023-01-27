package com.listeny.listeny.service;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.repository.CancionRepository;
import com.listeny.listeny.service.mapper.CancionMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CancionService extends AbstractBusinessService<Cancion, Long, CancionDto, CancionRepository, CancionMapper>{


    protected CancionService(CancionRepository cancionRepository, CancionMapper mapper) {
        super(cancionRepository, mapper);
    }

    public Cancion getCancionById(Long id) throws Exception {
        Optional<Cancion> cancion = getRepo().findById(id);
        if (cancion.isPresent()){
            return cancion.get();
        }
        throw new Exception("La canción de id '" + id + " 'no ha sido encontrada");
    }

    public void sacarCancionDeLista(Long id, Lista lista) throws Exception {
        Cancion cancion = getCancionById(id);
        lista.getCancionesLista().remove(cancion);
    }

    public void meterCancionALista(Long id, Lista lista) throws Exception {
        Cancion cancion = getCancionById(id);
        lista.getCancionesLista().add(cancion);
    }

    public void sacarCancionDeAlbum(Long id, Album album) throws Exception {
        Cancion cancion = getCancionById(id);
        album.getCancionesAlbum().remove(cancion);
    }

    public void meterCancionAlbum(Long id, Album album) throws Exception {
        Cancion cancion = getCancionById(id);
        album.getCancionesAlbum().add(cancion);
    }

}
