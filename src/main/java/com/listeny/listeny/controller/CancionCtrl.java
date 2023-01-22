package com.listeny.listeny.controller;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.services.CancionSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CancionCtrl {

    @Autowired
    private CancionSrvc cancionsrvc;

    @GetMapping (value="/canciones")
    public String listaCanciones(Model modelo) {
        List<Cancion> canciones= cancionsrvc.getCanciones();
        modelo.addAttribute("titulo","Lista de Canciones");
        modelo.addAttribute("albumes",canciones);
        System.out.println(Arrays.toString(canciones.toArray()));
        return "listaCanciones";
    }
}
