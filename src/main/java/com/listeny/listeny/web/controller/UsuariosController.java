package com.listeny.listeny.web.controller;


import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

import static com.listeny.listeny.util.ValidarFormatoPassword.ValidarFormato;


@Controller
public class UsuariosController extends AbstractController<UsuariosDto> {

    @Autowired
    UsuarioService service;
    //private final SessionService sessionService = new SessionService();

    @PostMapping("/login")
    public String iniciarSesion(Usuario usuario){
        //sessionService.crearSesionDelUsuario(usuario);
        return "inicio_logueado";
    }

    @GetMapping("/usuarios/{id}")
    public String userById (@PathVariable("id") Long idUser, Model model) throws Exception {
        UsuariosDto usuariosDto = service.getMapper().toDto(service.getUsuario(idUser));
        model.addAttribute("usuario", usuariosDto);
        return "/perfil_usuario";
    }


    // método para manejar el registro del usuario
    @PostMapping("/registro/save")
    public String registration(@Valid @ModelAttribute("usuario") UsuarioConPassDto usuarioDto, BindingResult result, Model model) {
        Optional<Usuario> existingEmail = service.getRepo().findUserByEmail(usuarioDto.getEmail());
        Optional<Usuario> existingUsername = service.getRepo().findUserByEmail(usuarioDto.getNombreUsuario());

        if (existingEmail.isPresent()) {
            result.rejectValue("email", null, "Este email ya está en uso");
        }

        if (existingUsername.isPresent()) {
            result.rejectValue("nombreUsuario", null, "Este nombre de usuario ya está en uso");
        }

        if (!ValidarFormato(usuarioDto.getClave())) {
            result.rejectValue("clave", null, "Esta clave no cumple los requisitos mínimos de seguridad");
        }

        if (result.hasErrors()) {
            model.addAttribute("usuario", usuarioDto);
            return "redirect:/registro";
        }

        Usuario usuario = service.getMapper().toEntity(usuarioDto);
        service.getRepo().save(usuario);
        return "redirect:/login";
    }

    @GetMapping("/canciones/favoritas")
    public String favoritas(Model model, Usuario usuario){
        model.addAttribute("favoritas", usuario.getCancionesFavoritas());
        return "playlist_canciones_favoritas";
    }

}
