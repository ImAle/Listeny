package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.service.UsuarioService;
import com.listeny.listeny.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuariosController {

    private UsuarioService service;
    private UsuarioMapper mapper;

    public UsuariosController(UsuarioService service) {
        this.service = service;
    }

//    @GetMapping("/usuarios/{id}")
//    public UsuariosDto userById (@PathVariable("id") Long idUser, ModelMap interfaz){
//        // Pasamos usuario a dto
//        UsuariosDto usuariosDto = this.mapper.toDto(this.service.findById(idUser));
//        // Lo metemos a una sesión
//        interfaz.addAttribute("userById", usuariosDto);
//        return usuariosDto;
//    }

}
