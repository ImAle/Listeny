package com.listeny.listeny.web.controller;

import com.listeny.listeny.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuscadorController {

    @Autowired
    ListaService listaService;

    @GetMapping("/buscador")
    public String buscador(Model model){
        model.addAttribute("recomendadas", listaService.getListasRecomendadas());
        return "buscador";
    }

}

