package com.listeny.listeny.controller;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.services.AlbumSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AlbumCtrl {

    @Autowired
    private AlbumSrvc albsrvc;

    @GetMapping (value = "/albumes")
    public String listaAlbumes(Model modelo) {
        List<Album> albs= albsrvc.getAlbumes();
        modelo.addAttribute("titulo","Lista de álbumes");
        modelo.addAttribute("albumes",albs);
        System.out.println(Arrays.toString(albs.toArray()));
        return "listaAlbumes";
    }
}
