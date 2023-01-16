package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.service.UsuariosService;
import com.listeny.listeny.service.mapper.UsuariosMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UsuariosController {

    private UsuariosService service;
    private UsuariosMapper mapper;

    public UsuariosController(UsuariosService service) {
        this.service = service;
    }

    @GetMapping("/usuarios/{id}")
    public UsuariosDto userById (@PathVariable("id") Long idUser, ModelMap interfaz){
        // Pasamos usuario a dto
        UsuariosDto usuariosDto = this.mapper.toDto(this.service.findById(idUser));
        // Lo metemos a una sesión
        interfaz.addAttribute("userById", usuariosDto);
        return usuariosDto;
    }

}
