package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.AlbumDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlbumController extends AbstractController<AlbumDto> {

    private AlbumService service;

    public AlbumController(AlbumService service){
        this.service = service;
    }

    @GetMapping("/album/{id}")
    public String vistaAlbum (@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("album", service.getAlbumById(id));
        model.addAttribute("canciones", service.getAlbumById(id).getCancionesAlbum());
        return "album_visto";
    }

    @GetMapping("/crear/album/{id}")
    public String crearAlbum(@ModelAttribute("id") Long id, Model model) throws Exception {
        Album album = service.getAlbumById(id);
        model.addAttribute("album", album);
        return "subir_canciones_album";
    }

    @GetMapping("/editar/album")
    public String editarAlbum(@ModelAttribute("id") Long id, Model model) throws Exception {
        model.addAttribute("album", service.getAlbumById(id));
        return "subir_canciones_album";
    }

    @PostMapping("/crear/album")
    public String albumCreado(@ModelAttribute("album") Album album, Model model){
        service.getRepo().save(album);
        Long id = album.getId();
        model.addAttribute("id", id);
        return "redirect:/crear/album" + id;
    }



}
