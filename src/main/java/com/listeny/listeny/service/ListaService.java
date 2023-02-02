package com.listeny.listeny.service;

import com.listeny.listeny.Dto.ListaDeListaDto;
import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.repository.ListaRepository;
import com.listeny.listeny.service.mapper.ListaMapper;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaService extends AbstractBusinessService<Lista, Long, ListaDto, ListaRepository, ListaMapper>{

    @Autowired
    public ListaService(ListaRepository repo, ListaMapper mapper) {
        super(repo, mapper);
    }

    public ListaDto getLista(Long idLista) throws Exception {
        Optional<ListaDto> listaDto = getRepo().findById(idLista).map(getMapper()::toDto);
        if(listaDto.isPresent()){
            return listaDto.get();
        }
        throw new Exception("La lista no existe");
    }

    public List<ListaDeListaDto> getListaDeLista (List<Long> id){
        List<ListaDeListaDto> listasPreparadas = new ArrayList<>();
        for (Long lista: id) {
            Optional<ListaDeListaDto> listaDto = getRepo().findById(lista).map(getMapper()::toDtoListaDeLista);
            listaDto.ifPresent(listasPreparadas::add);
        }
        return listasPreparadas;
    }

    //5 playlists aleatoria según tus gustos
    public void getListasByCategoria(Long categoriaId){
        
    }

    // Obtener cinco listas al azar
    public List<Lista> getListasAlAzar(){
        List<Lista> listasAPantalla = new ArrayList<>();
        for (Long id: getElementoAzarId()) {
            Optional<Lista> lista = getRepo().findById(id);
            lista.ifPresent(listasAPantalla::add);
        }
        return listasAPantalla;
    }

    // Creación de una nueva lista con los valores no null
    public Long copyListaToNewLista(Categoria categoria, Long idListaACopiar, String nombre, Usuario esteUsuario) throws Exception {
        ListaDto listaDto = new ListaDto();
        listaDto.setNombre(nombre);
        listaDto.setPropietarioLista(esteUsuario);
        listaDto.setListasCategoria(categoria);
        listaDto.setCancionesLista(getCancionesDeLista(idListaACopiar));
        return listaDto.getId();
    }


    // Obtener las canciones de una lista, para enviarlos a reproducir o para copiarlos en una nueva lista/álbum
    // Usar el método getCancionesDeLista(Long idLista) para obtener las canciones de la lista y encasquetarselo a cancionesToArchivos
    public List<Cancion> getCancionesDeLista(Long idLista) throws Exception {
        Optional<ListaDto> listaDto = getRepo().findById(idLista).map(getMapper()::toDto);
        if(listaDto.isPresent()){
            return listaDto.get().getCancionesLista();
        }
        throw new Exception("La lista no existe");
    }

//    public List<File> cancionesToArchivos(List<Cancion> canciones) {
//        List<File> archivos = new ArrayList<>();
//        for (Cancion cancion : canciones) {
//            archivos.add(new File(cancion.getUrl()));
//        }
//        return archivos;
//    }

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

}
