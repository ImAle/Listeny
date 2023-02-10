package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.LoginDto;
import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @Autowired
    CancionService cancionService;
    @Autowired
    ListaService listaService;
    @Autowired
    ReproduccionService reproduccionService;
    @Autowired
    AlbumService albumService;




}
