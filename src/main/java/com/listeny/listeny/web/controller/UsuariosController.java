package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuariosController extends AbstractController<UsuariosDto> {

    private UsuarioService service;

    public UsuariosController (UsuarioService service){
        this.service = service;
    }

    @GetMapping("/usuarios/{id}")
    public String userById (@PathVariable("id") Long idUser, Model interfaz) throws Exception {
        // Pasamos usuario a dto
        UsuariosDto usuariosDto = service.getMapper().toDto(service.findUsuarioById(idUser));
        // Lo metemos a una sesión
        interfaz.addAttribute("userById", usuariosDto);
        return "/usuarios/detalles";
    }

}
