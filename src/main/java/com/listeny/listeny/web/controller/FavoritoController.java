package com.listeny.listeny.web.controller;

import com.listeny.listeny.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoritoController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/megusta")
    public void seguirUsuario(@RequestParam("seguidor") Long yo, @RequestParam("seguido") Long aQuienSigo) throws Exception {
        usuarioService.seguirA(usuarioService.getUsuario(aQuienSigo), usuarioService.getUsuario(yo));
    }

    @GetMapping("/nomegusta")
    public void dejarSeguirUsuario(@RequestParam("seguidor") Long yo, @RequestParam("seguido") Long aQuienSigo) throws Exception {
        usuarioService.dejarDeSeguirA(usuarioService.getUsuario(aQuienSigo), usuarioService.getUsuario(yo));
    }




}
