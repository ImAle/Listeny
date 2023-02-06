package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.service.CancionService;
import com.listeny.listeny.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CancionController extends AbstractController<CancionDto>{

    @Autowired
    CancionService cancionService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/canciones/misCanciones")
    public String misCanciones(Model model, Long idUsuario) throws Exception {
        List<Cancion> canciones = usuarioService.getUsuario(idUsuario).getPropietarioCanciones();
        model.addAttribute("canciones", cancionService.getMapper().toDtoCancionesListadas(canciones));
        return "subir_canciones_usuario";
    }

}
