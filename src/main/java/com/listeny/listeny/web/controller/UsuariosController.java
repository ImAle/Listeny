package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.service.UsuarioService;
import com.listeny.listeny.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController //@Controller
public class UsuariosController {

    private UsuarioService service;

    public UsuariosController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarios/{id}")
    public String userById (@PathVariable("id") Long idUser, ModelMap interfaz){
        // Pasamos usuario a dto
        Optional<UsuariosDto> usuariosDto = Optional.of(UsuarioMapper.toDto(this.service.findById(idUser).get()));
        if(usuariosDto.isPresent()){
            // Lo metemos a una sesión
            interfaz.addAttribute("userById", usuariosDto);
            return "/usuarios/detalles";
        }
        return "/usuarios/noExiste";
    }

    // Comprobar que datos se devuelven con JSON (@RestController)
    @GetMapping("/usuarios/detalles/{id}")
    public UsuariosDto userByIdJson (@PathVariable("id") Long idUser, ModelMap interfaz){
        return UsuarioMapper.toDto(this.service.findById(idUser).get());
    }

}
