package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.service.SessionService;
import com.listeny.listeny.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsuariosController extends AbstractController<UsuariosDto> {

    private final UsuarioService service;
    private final SessionService sessionService = new SessionService();
    public UsuariosController (UsuarioService service){
        this.service = service;
    }

    @GetMapping("/")
    public String iniciarSesion(Usuario usuario){
        sessionService.crearSesionDelUsuario(usuario);
        return "inicio_logueado";
    }

    @GetMapping("/usuarios/{id}")
    public String userById (@PathVariable("id") Long idUser, Model model) throws Exception {
        // Pasamos usuario a dto
        UsuariosDto usuariosDto = service.getMapper().toDto(service.getUsuario(idUser));
        // Lo metemos a una sesión
        model.addAttribute("usuario", usuariosDto);
        return "/perfil_usuario";
    }

    @PostMapping("/registro")
    public String procesarFormulario(@ModelAttribute Usuario usuario){
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombreUsuario(usuario.getNombreUsuario());
        usuarioNuevo.setEmail(usuario.getEmail());
        usuarioNuevo.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioNuevo.setSexo(usuario.getSexo());
        usuarioNuevo.setImagen(usuario.getImagen());
        usuarioNuevo.setImagenFondo(usuario.getImagenFondo());
        usuarioNuevo.setEsArtista(usuario.getEsArtista());
        // Checar nombreUsuario, email y mínimo de seguridad clave
        service.encriptarClaveYGuardar(usuarioNuevo, usuario);
        return "index";
    }

}
