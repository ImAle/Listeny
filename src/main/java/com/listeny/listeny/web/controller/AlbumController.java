package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.AlbumDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AlbumController extends AbstractController<AlbumDto> {

    private AlbumService service;

    @GetMapping("/album/{id}")
    public Album vistaAlbum (@PathVariable("id") Long id, Model model) throws Exception {
        Album album = this.service.getAlbumPorId(id);
        return album;
    }
}
