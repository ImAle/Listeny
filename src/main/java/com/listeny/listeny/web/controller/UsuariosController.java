package com.listeny.listeny.web.controller;


import com.listeny.listeny.Dto.LoginDto;
import com.listeny.listeny.Dto.RolDto;
import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.service.*;
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
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    RolService rolService;
    @Autowired
    CancionService cancionService;
    @Autowired
    ListaService listaService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    ReproduccionService reproduccionService;
    @Autowired
    AlbumService albumService;

    public UsuariosController(UsuarioService service, RolService rolService) {
        this.service = service;
        this.rolService = rolService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("canciones", cancionService.getMapper().toDtoListaDeCanciones(cancionService.getCancionesParaInicio()));
        return "index";
    }

    @PostMapping("/login")
    public String iniciarSesion(@ModelAttribute(name="formlogin") LoginDto usuario) {
        System.out.println("Entrando en controlador login");

        Optional<Usuario> existeUsuarioConEseEmail = service.getRepo().findUsuarioByEmail(usuario.getEmail());

        if (existeUsuarioConEseEmail.isEmpty()) {
            return "redirect:/login";
        }

        Usuario usuarioConEseEmail = existeUsuarioConEseEmail.get();

        if (!passwordEncoder.matches(usuario.getClave(), usuarioConEseEmail.getClave())) {
            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/")
    public String inicioRaiz() {
        return "redirect:/home";
    }
    @GetMapping("/accesodenegado")
    public String accesodenegado() {
        return "accesodengado";
    }
    @GetMapping("/home")
    public String inicio(Model model){
        Album album = new Album();
        Lista lista = new Lista();
        //model.addAttribute("gustos", listaService.getMapper().toDtoListaDeLista(listaService.getListasPorGustos(idUsuario)));
        //model.addAttribute("cancionesHistorial", cancionService.getMapper().toDtoListaDeCanciones(reproduccionService.getHistorialUltimasCancionesReproducidas(idUsuario)));
        model.addAttribute("listasMasReproducidas", listaService.getListasMasReproducidas());
        model.addAttribute("albumesMasReproducidos", albumService.getMapper().toDtoListaDeAlbumes((albumService.getAlbumesRecomendados())));
        model.addAttribute("albumesRecomendados", albumService.getAlbumesRecomendados());
        model.addAttribute("album", album);
        model.addAttribute("lista", lista);
        return "inicio_logueado";
    }

    @GetMapping("/usuarios/{id}")
    public String userById(@PathVariable("id") Long idUser, Model model) throws Exception {
        UsuariosDto usuariosDto = service.getMapper().toDto(service.getUsuario(idUser));
        model.addAttribute("usuario", usuariosDto);
        return "perfil_usuario";
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

        Optional<Usuario> existingEmail = service.getRepo().findUsuarioByEmail(usuarioDto.getEmail());
        Optional<Usuario> existingUsername = service.getRepo().findUsuarioByNombreUsuario(usuarioDto.getNombreUsuario());


        if (existingEmail.isPresent()) {
            result.rejectValue("email", "email_used", "Este email ya está en uso");
        }

        if (existingUsername.isPresent()) {
            result.rejectValue("nombreUsuario", "username_used", "Este nombre de usuario ya está en uso");
        }

        if (!ValidarFormato(usuarioDto.getClave())) {
            result.rejectValue("clave", "password_invalid", "Esta clave no cumple los requisitos mínimos de seguridad");
        }

        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
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
        model.addAttribute("lista", new Lista());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "playlist_canciones_favoritas";
    }

}
