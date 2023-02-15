package com.listeny.listeny.service;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.repository.AlbumRepository;
import com.listeny.listeny.repository.CancionRepository;
import com.listeny.listeny.repository.ListaRepository;
import com.listeny.listeny.service.mapper.CancionMapper;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CancionService extends AbstractBusinessService<Cancion, Long, CancionDto, CancionRepository, CancionMapper> {

    @Autowired
    StreamingService streamingService;
    private final AlbumRepository albumRepository;
    private final ListaRepository listaRepository;

    public CancionService(CancionRepository cancionRepository, CancionMapper mapper,
                          AlbumRepository albumRepository,
                          ListaRepository listaRepository) {
        super(cancionRepository, mapper);
        this.albumRepository = albumRepository;
        this.listaRepository = listaRepository;
    }

    public Cancion getCancionById(Long id) throws Exception {
        Optional<Cancion> cancion = getRepo().findById(id);
        if (cancion.isPresent()) {
            return cancion.get();
        }
        throw new Exception("Esta canción no existe");
    }

    public void cambiarEstadoPublico (Cancion cancion) {
        if(cancion.getPublica()){
            cancion.setPublica(false);
        }else{
            cancion.setPublica(true);
        }
        getRepo().save(cancion);
    }

    public List<Cancion> getCancionesRecomendadas() {
        List<Cancion> cancionesAPantalla = new ArrayList<>();
        for (Long id : generadorId(5)) {
            Optional<Cancion> cancion = getRepo().findById(id);
            cancionesAPantalla.add(existeYPublica(cancion));
        }
        return cancionesAPantalla;
    }



    public Cancion existeYPublica (Optional<Cancion> cancion){
        if(cancion.isPresent() && cancion.get().getPublica()){
            return cancion.get();
        }
        return existeYPublica(getRepo().findById(generadorId(1).iterator().next()));
    }

    public List<Cancion> getCancionesParaInicio() {
        List<Cancion> cancionesAPantalla = new ArrayList<>();

        for (Long id : generadorId(20)) {
            Optional<Cancion> cancion = getRepo().findById(id);
            cancionesAPantalla.add(existeYPublica(cancion));
        }

        return cancionesAPantalla;
    }

    public void sacarCancionDeLista(Long id, Lista lista) throws Exception {
        Cancion cancion = getCancionById(id);
        lista.getCancionesLista().remove(cancion);
        cancion.getCancionEnLista().remove(lista);
        getRepo().save(cancion);
        listaRepository.save(lista);
    }

    public void meterCancionALista(Long id, Lista lista) throws Exception {
        Cancion cancion = getCancionById(id);
        lista.getCancionesLista().add(cancion);
        cancion.getCancionEnLista().add(lista);
        getRepo().save(cancion);
        listaRepository.save(lista);
    }

    public void sacarCancionDeAlbum(Long id, Album album) throws Exception {
        Cancion cancion = getCancionById(id);
        album.getCancionesAlbum().remove(cancion);
        cancion.getCancionEnAlbum().remove(album);
        getRepo().save(cancion);
        albumRepository.save(album);
    }

    public void meterCancionAlbum(Long id, Album album) throws Exception {
        Cancion cancion = getCancionById(id);
        album.getCancionesAlbum().add(cancion);
        cancion.getCancionEnAlbum().add(album);
        getRepo().save(cancion);
        albumRepository.save(album);
    }

    // Modificar con la URL adecuada
    public String subirMp3(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String URL = "src/main/resources/static/canciones/";

        assert fileName != null;
        if (!fileName.endsWith(".mp3")) {
            throw new IllegalArgumentException("El archivo no es un MP3");
        }

        String filePath = URL + fileName;
        File destinationFile = new File(filePath);
        file.transferTo(destinationFile);
        return filePath;
    }

    public String subirUnaImagen(MultipartFile file) throws IOException {
        return subirImagen(file);
    };

    public void eliminarUnaImagen(String imagen){
        borrarImagen(imagen);
    }

    public void eliminarMp3(Long idCancion){
        Optional<Cancion> cancion = getRepo().findById(idCancion);
        cancion.ifPresent(cancionAEliminar -> getRepo().delete(cancionAEliminar));
    }

    public void reproducirCancion(Cancion cancion){
        List<Cancion> canciones= new ArrayList<>();
        canciones.add(cancion);
        streamingService.setCanciones(canciones);
        streamingService.start(new Stage());
    }



}
