package com.listeny.listeny.web.controller;


import com.listeny.listeny.Dto.LoginDto;
import com.listeny.listeny.Dto.RolDto;
import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.service.CancionService;
import com.listeny.listeny.service.RolService;
import com.listeny.listeny.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.listeny.listeny.util.ValidarFormatoPassword.ValidarFormato;


@Controller
public class UsuariosController extends AbstractController<UsuariosDto> {

    @Autowired
    UsuarioService service;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Autowired
    CancionService cancionService;

    public UsuariosController(UsuarioService service, RolService rolService) {
        this.service = service;
        this.rolService = rolService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        LoginDto login = new LoginDto();
        model.addAttribute("usuario", login);
        model.addAttribute("canciones", cancionService.getMapper().toDtoListaDeCanciones(cancionService.getCancionesParaInicio()));
        return "index";
    }

    @PostMapping("/login")
    public String iniciarSesion(@ModelAttribute("usuario") LoginDto usuario) {
        System.out.println("Pasa por login, método post");
        Optional<Usuario> existeEmail = service.getRepo().findUserByEmail(usuario.getEmail());
        if (existeEmail.isPresent()) {
            Optional<Usuario> comprobarUsuario = service.getRepo().findUserByEmail(existeEmail.get().getEmail());
            if (passwordEncoder.matches(usuario.getClave(), comprobarUsuario.get().getClave())) {
                return "inicio_logueado";
            }
            return "index";
        }
        return "index";
    }

    @GetMapping("/usuarios/{id}")
    public String userById(@PathVariable("id") Long idUser, Model model) throws Exception {
        UsuariosDto usuariosDto = service.getMapper().toDto(service.getUsuario(idUser));
        model.addAttribute("usuario", usuariosDto);
        return "/perfil_usuario";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        UsuarioConPassDto usuarioConPassDto = new UsuarioConPassDto();
        //Obtengo la lista de roles
        final List<RolDto> rolDTOList = rolService.buscarTodos();
        // para las fechas ver referencia
        //https://stackoverflow.com/questions/68662850/datepicker-bootstrap-5
        model.addAttribute("usuario", usuarioConPassDto);
        model.addAttribute("listaRoles", rolDTOList);
        return "formulario_registro";
    }

    // método para manejar el registro del usuario
    @PostMapping("/registro")
    public String registration(@Valid @ModelAttribute("usuario") UsuarioConPassDto usuarioDto, BindingResult result, Model model) {
        System.out.println("los datos a guardar son:" + usuarioDto.getSexo());
        System.out.println("los datos a guardar son:" + usuarioDto.getNombreUsuario());

        Optional<Usuario> existingEmail = service.getRepo().findUserByEmail(usuarioDto.getEmail());
        Optional<Usuario> existingUsername = service.getRepo().findByUsername(usuarioDto.getNombreUsuario());


        if (existingEmail.isPresent()) {
            System.out.println("Rechazo1");
            result.rejectValue("email", null, "Este email ya está en uso");

        }

        if (existingUsername.isPresent()) {
            System.out.println("Rechazo2");
            result.rejectValue("nombreUsuario", null, "Este nombre de usuario ya está en uso");
        }

        if (!ValidarFormato(usuarioDto.getClave())) {
            System.out.println("Rechazo3");
            result.rejectValue("clave", null, "Esta clave no cumple los requisitos mínimos de seguridad");
        }

        if (result.hasErrors()) {
            System.out.println("Rechazo4");
            model.addAttribute("usuario", usuarioDto);
            return "redirect:/registro";
        }

        Usuario usuario = service.getMapper().toEntity(usuarioDto);
        service.encriptarClaveYGuardar(usuario);
        return "redirect:/login";
    }

    @GetMapping("/canciones/favoritas")
    public String favoritas(Model model, Usuario usuario) {
        model.addAttribute("favoritas", usuario.getCancionesFavoritas());
        return "playlist_canciones_favoritas_usuario";
    }

}
