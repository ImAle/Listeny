package com.listeny.listeny.service;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.repository.CancionRepository;
import com.listeny.listeny.service.mapper.CancionMapper;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CancionService extends AbstractBusinessService<Cancion, Long, CancionDto, CancionRepository, CancionMapper> {


    protected CancionService(CancionRepository cancionRepository, CancionMapper mapper) {
        super(cancionRepository, mapper);
    }

    public Cancion getCancionById(Long id) throws Exception {
        Optional<Cancion> cancion = getRepo().findById(id);
        if (cancion.isPresent()) {
            return cancion.get();
        }
        throw new Exception("Esta canción no existe");
    }

    public void cambiarEstadoPublico (Long idCancion) throws Exception {
        Cancion cancion = getCancionById(idCancion);
        if(cancion.getPublica()){
            cancion.setPublica(false);
        }else{
            cancion.setPublica(true);
        }
        getRepo().save(cancion);
    }

    public List<Cancion> getCancionesRecomendadas() {
        List<Cancion> cancionesAPantalla = new ArrayList<>();
        for (Long id : getElementoAzarId(5)) {
            Optional<Cancion> cancion = getRepo().findById(id);
            cancion.ifPresent(cancionesAPantalla::add);
        }
        return cancionesAPantalla;
    }

    public List<Cancion> getCancionesParaInicio() {
        List<Cancion> cancionesAPantalla = new ArrayList<>();
        for (Long id : getElementoAzarId(20)) {
            Optional<Cancion> cancion = getRepo().findById(id);
            cancion.ifPresent(cancionesAPantalla::add);
        }
        return cancionesAPantalla;
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

    // Modificar con la URL adecuada
    public void subirMp3(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String URL = "path/to/upload/directory/";

        String filePath = URL + fileName;
        File destinationFile = new File(filePath);
        file.transferTo(destinationFile);
    }

    public void eliminarMp3(Long idCancion){
        Optional<Cancion> cancion = getRepo().findById(idCancion);
        cancion.ifPresent(cancionAEliminar -> getRepo().delete(cancionAEliminar));
    }


    // Ejecutar un Stream de una canción
    public void play(String song) {
        //String song = "http://www.ntonyx.com/mp3files/Morning_Flower.mp3";
        Player mp3player = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new URL(song).openStream());
            mp3player = new Player(in);
            mp3player.play();
        } catch (NullPointerException | JavaLayerException | IOException ex) {
            System.out.println("Error al reproducir la canción");
        }

    }

//
//    public void playSong(File archivo) {
//        try {
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
//            Clip cancion = AudioSystem.getClip();
//            cancion.open(audioInputStream);
//            cancion.start();
//        } catch (Exception e) {
//            System.out.println("Error al reproducir canción: " + e.getMessage());
//        }
//    }
//
//    public void stopSong(Clip cancion) {
//        if (cancion != null && cancion.isRunning()) {
//            cancion.stop();
//        }
//    }
//
//    public void playNextSong(List<File> cancion, int indice) {
//        if (indice + 1 < cancion.size()) {
//            playSong(cancion.get(indice + 1));
//        } else {
//            System.out.println("No hay más canciones en la lista");
//        }
//    }
//
//    public void playPreviousSong(List<File> cancion, int indice) {
//        if (indice - 1 >= 0) {
//            playSong(cancion.get(indice - 1));
//        } else {
//            System.out.println("No hay más canciones anteriores en la lista");
//        }
//    }
//
//    public void playRandomSong(List<File> lista) {
//        if (lista.isEmpty()) {
//            System.out.println("La lista de canciones está vacía");
//        } else {
//            Random random = new Random();
//            int indiceRandom = random.nextInt(lista.size());
//            playSong(lista.get(indiceRandom));
//        }
//    }
//
}
