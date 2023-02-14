package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.AlbumDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.service.AlbumService;
import com.listeny.listeny.service.CategoriaService;
import com.listeny.listeny.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class AlbumController extends AbstractController<AlbumDto> {

    @Autowired
    AlbumService service;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    ListaController listaController;
    @Autowired
    UserServiceImpl sessionService;

    public AlbumController(AlbumService service){
        this.service = service;
    }

    @GetMapping("/album/{id}")
    public String vistaAlbum (@PathVariable("id") Long id, Model model) throws Exception {
        List<Cancion> canciones = service.getAlbumById(id).getCancionesAlbum();
        double sumaDuracion = canciones.stream().mapToDouble(Cancion::getDuracion).sum();
        model.addAttribute("album", service.getAlbumById(id));
        model.addAttribute("canciones", service.getAlbumById(id).getCancionesAlbum());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("duracion", sumaDuracion);
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        return "album_visto";
    }

    @GetMapping("/crear/album/{id}")
    public String crearAlbum(@PathVariable("id") Long id, Model model) throws Exception {
        Album album = service.getAlbumById(id);
        model.addAttribute("album", album);
        model.addAttribute("canciones", album.getCancionesAlbum());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        return "subir_canciones_album";
    }

    @GetMapping("/editar/album/{id}")
    public String editarAlbum(@PathVariable("id") Long id, Model model) throws Exception {
        Album album = service.getAlbumById(id);
        model.addAttribute("album", album);
        model.addAttribute("canciones", album.getCancionesAlbum());
        return "subir_canciones_album";
    }

    @PostMapping("/editar/album/{id}")
    public String albumEditado(@PathVariable("id") Long id, @ModelAttribute("album") Album album) throws Exception {
        Album albumDelId = service.getAlbumById(id);
        System.out.println("holaaaaaa");
        System.out.println(album);
        if(album.getTitulo() != null && !Objects.equals(album.getTitulo(), "")){
            albumDelId.setTitulo(album.getTitulo());
        }
        if(album.getImagen() != null){
            albumDelId.setImagen(album.getImagen());
        }
        if(album.getDescripcion() != null && !Objects.equals(album.getDescripcion(), "")){
            albumDelId.setDescripcion(album.getDescripcion());
        }
        if(album.getPublico() != null) {
            albumDelId.setPublico(album.getPublico());
        }

        service.getRepo().save(albumDelId);
        return "redirect:/editar/album/" + id;
    }


    @PostMapping("/crear/album")
    public String albumCreado(@ModelAttribute("album") Album album, Model model){
        album.setPropietarioAlbum(sessionService.getSession());
        service.getRepo().save(album);
        Long id = album.getId();
        model.addAttribute("id", id);
        return "redirect:/crear/album/" + id;
    }

    @GetMapping("/eliminar/album/{id}")
    public String eliminarAlbum(@PathVariable("id") Long id) throws Exception {
        Album album = service.getAlbumById(id);
        service.getRepo().delete(album);
        return "redirect:/home";
    }

}
