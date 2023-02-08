package com.listeny.listeny.service;

import com.google.common.collect.Lists;
import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.AlbumRepository;
import com.listeny.listeny.repository.ListaRepository;
import com.listeny.listeny.service.mapper.ListaMapper;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaService extends AbstractBusinessService<Lista, Long, ListaDto, ListaRepository, ListaMapper>{

    @Autowired
    CancionService cancionService;
    @Autowired
    StreamingService streamingService;
    private final AlbumRepository albumRepository;

    @Autowired
    public ListaService(ListaRepository repo, ListaMapper mapper,
                        AlbumRepository albumRepository) {
        super(repo, mapper);
        this.albumRepository = albumRepository;
    }

    public Lista getLista(Long idLista) throws Exception {
        Optional<Lista> lista = getRepo().findById(idLista);
        if(lista.isPresent()){
            return lista.get();
        }
        throw new Exception("La lista no existe");
    }

    public void cambiarEstadoPublico (Long idLista) throws Exception {
        Lista lista = getLista(idLista);
        if(lista.getPublica()){
            lista.setPublica(false);
        }else{
            lista.setPublica(true);
        }
        getRepo().save(lista);
    }

//    public List<ListaDeListaDto> getListaDeLista (List<Long> id){
//        List<ListaDeListaDto> listasPreparadas = new ArrayList<>();
//        for (Long lista: id) {
//            Optional<ListaDeListaDto> listaDto = getRepo().findById(lista).map(getMapper()::toDtoListaDeLista);
//            listaDto.ifPresent(listasPreparadas::add);
//        }
//        return listasPreparadas;
//    }

    //Playlists por categoría
    public List<Lista> getListasByCategoria(Long categoriaId){
        return getRepo().findListasByListasCategoria_Id(categoriaId);
    }

    // Obtener cinco listas al azar
    public List<Lista> getListasRecomendadas(){
        List<Lista> listasAPantalla = new ArrayList<>();
        for (Long id : generadorId(5)) {
            Optional<Lista> lista = getRepo().findById(id);
            listasAPantalla.add(existeYPublica(lista));
        }
        return listasAPantalla;
    }

    public Lista existeYPublica (Optional<Lista> lista){
        if(lista.isPresent() && lista.get().getPublica()){
            return lista.get();
        }
        return existeYPublica(getRepo().findById(generadorId(1).iterator().next()));
    }



    // Copiar lista a lista
    public Long copyListaALista(Long idListaACopiar, String nombre, Usuario esteUsuario) throws Exception {
        Lista listaACopiar = getLista(idListaACopiar);
        Lista lista = new Lista();
        lista.setNombre(nombre);
        lista.setPropietarioLista(esteUsuario);
        lista.setListasCategoria(listaACopiar.getListasCategoria());
        lista.setCancionesLista(listaACopiar.getCancionesLista());
        getRepo().save(lista);
        return lista.getId();
    }

    public Long copyListaAAlbum(Long idListaACopiar, String nombre, Usuario esteUsuario) throws Exception {
        Lista listaACopiar = getLista(idListaACopiar);
        Album album = new Album();
        album.setTitulo(nombre);
        album.setPropietarioAlbum(esteUsuario);
        album.setCancionesAlbum(listaACopiar.getCancionesLista());
        albumRepository.save(album);
        return album.getId();
    }

//    public List<File> cancionesToArchivos(List<Cancion> canciones) {
//        List<File> archivos = new ArrayList<>();
//        for (Cancion cancion : canciones) {
//            archivos.add(new File(cancion.getUrl()));
//        }
//        return archivos;
//    }

    public List<Lista> getListasPorGustos(Long idCategoria){
        List<Lista> listasPorGusto = getListasByCategoria(idCategoria);
        List<List<Lista>> particionEnCinco = Lists.partition(listasPorGusto, 5);

        return particionEnCinco.get(1);
    }

    public List<Lista> getListasMasReproducidas(){
        List<Lista> masReproducidas = Lists.newArrayList(getRepo().listasMasReproducidas());
        List<List<Lista>> particionEnCinco = Lists.partition(masReproducidas, 5);

        return particionEnCinco.get(1);
    }

    public void reproducirLista(Lista lista){
        streamingService.setCanciones(lista.getCancionesLista());
        streamingService.start(new Stage());
    }

    public void subirUnaImagen(MultipartFile file) throws IOException {
        subirImagen(file);
    };

    public void eliminarUnaImagen(String imagen){
        borrarImagen(imagen);
    }

    public void cambiarUnaImagen (MultipartFile file, String imagen) throws IOException {
        cambiarImagen(file, imagen);
    }

    public void agregarCancion(Lista lista, Cancion cancion) {
        if(!cancion.getPublica()){
            cancionService.cambiarEstadoPublico(cancion);
        }
        lista.getCancionesLista().add(cancion);
    }

}
