package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.Dto.LoginDto;
import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.service.CancionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    private final CancionService service;

    public HomeController(CancionService service) {
        this.service = service;
    }

    @GetMapping("/registro")
    public String registro(Model usuario){
        usuario.addAttribute("usuario", new UsuarioConPassDto());
        return "formulario_registro";
    }

    @GetMapping("/login")
    public String login(Model usuario, Model canciones){
        usuario.addAttribute("usuario", new LoginDto());
        canciones.addAttribute("canciones", service.getCancionesParaInicio());
        return "index";
    }
}
