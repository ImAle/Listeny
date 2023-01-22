package com.listeny.listeny.controller;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.services.CancionSrvc;
import com.listeny.listeny.services.CategoriaSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CategoriaCtrl {

    @Autowired
    private CategoriaSrvc categsrvc;

    @GetMapping(value="/categorias")
    public String listaCategorias(Model modelo) {
        List<Categoria> categorias= categsrvc.getCategorias();
        modelo.addAttribute("titulo","Lista de Categorias");
        modelo.addAttribute("categorias",categorias);
        System.out.println(Arrays.toString(categorias.toArray()));
        return "listaCategorias";
    }
}
