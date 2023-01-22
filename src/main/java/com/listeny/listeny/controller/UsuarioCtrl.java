package com.listeny.listeny.controller;


import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.services.UsuarioSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class UsuarioCtrl {

    @Autowired
    private UsuarioSrvc ususrvc;

    @GetMapping(value="/usuarios")
    public String listaUsuarios(Model modelo) {
        List<Usuario> usus= ususrvc.getUsuarios();
        modelo.addAttribute("titulo","Lista de Usuarios");
        modelo.addAttribute("usuarios",usus);
        //System.out.println(Arrays.toString(usus.toArray()));
        return "listaUsuarios";
    }
}
