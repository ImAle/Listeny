package com.listeny.listeny.web.controller;


import com.listeny.listeny.Dto.*;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.service.*;
import jakarta.websocket.Session;
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
    @Autowired
    UserServiceImpl sessionService;

    public UsuariosController(UsuarioService service, RolService rolService) {
        this.service = service;
        this.rolService = rolService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("canciones", cancionService.getMapper().toDtoListaDeCanciones(cancionService.getCancionesParaInicio()));
        return "index";
    }

//    @PostMapping("/login")
//    public String iniciarSesion(@ModelAttribute(name="formlogin") LoginDto usuario) {
//        System.out.println("Entrando en controlador login");
//
//        Optional<Usuario> existeUsuarioConEseEmail = service.getRepo().findUsuarioByEmail(usuario.getEmail());
//
//        if (existeUsuarioConEseEmail.isEmpty()) {
//            return "redirect:/login";
//        }
//
//        Usuario usuarioConEseEmail = existeUsuarioConEseEmail.get();
//
//        if (!passwordEncoder.matches(usuario.getClave(), usuarioConEseEmail.getClave())) {
//            return "redirect:/login";
//        }
//
//        return "redirect:/home";
//    }

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
//        List<ListaDeCancionDto> cancionesHistorial = cancionService.getMapper().toDtoListaDeCanciones(reproduccionService.getHistorialUltimasCancionesReproducidas(sessionService.getSession().getId()));
//        List<ListaDeListaDto> gustos = listaService.getMapper().toDtoListaDeLista(listaService.getListasPorGustos(sessionService.getSession().getId()));
//        if(gustos.size() > 4){
//            model.addAttribute("gustos", gustos);
//        }
//        if(cancionesHistorial.size() > 4) {
//            model.addAttribute("cancionesHistorial", cancionesHistorial);
//        }
        Usuario usu =  sessionService.getSession();
        //Optional<List<Usuario>> seguidox = Optional.of(usu.getSeguidoPor());
        //service.getMapper().toDto(usu);
        model.addAttribute("listasMasReproducidas", listaService.getListasMasReproducidas());
        model.addAttribute("albumesMasReproducidos", albumService.getMapper().toDtoListaDeAlbumes((albumService.getAlbumesRecomendados())));
        model.addAttribute("albumesRecomendados", albumService.getAlbumesRecomendados());
        model.addAttribute("rol", sessionService.getSession().getRolDelUsuario().getId());
        model.addAttribute("nuevoAlbum", new Album());
        model.addAttribute("nuevaLista", new Lista());
        return "inicio_logueado";
    }

    @GetMapping("/usuarios/{id}")
    public String userById(@PathVariable("id") Long idUser, Model model) throws Exception {
        Usuario usuario = service.getUsuario(idUser);
        model.addAttribute("nuevoAlbum", new Album());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("usuario", service.getMapper().toDto(usuario));
        model.addAttribute("propietarioListas", usuario.getPropietarioListas());
        if (usuario.getRolDelUsuario().getId() == 2){
            model.addAttribute("propietarioAlbumes", usuario.getPropietarioAlbumes());
            return "perfil_de_artista_visitado";
        }
        return "perfil_de_usuario_visitado";
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
    public String favoritas(Model model) {
        model.addAttribute("favoritas", sessionService.getSession().getCancionesFavoritas());
        model.addAttribute("lista", new Lista());
        model.addAttribute("album", new Album());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "playlist_canciones_favoritas";
    }

    @GetMapping("/perfil")
    public String miPerfil(Model model){
        final List<RolDto> rolDTOList = rolService.buscarTodos();

        model.addAttribute("yo", sessionService.getSession());
        model.addAttribute("albumesFavoritos", sessionService.getSession().getAlbumesFavoritos());
        model.addAttribute("listasFavoritas", sessionService.getSession().getListasFavoritos());
        model.addAttribute("propietarioCancion", listaService.getRepo().findListasByPropietarioLista(sessionService.getSession()));
        model.addAttribute("sigoA", sessionService.getSession().getSigueA());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("listaRoles", rolDTOList);
        return "perfil_usuario";
    }

    @PostMapping("/perfil/actualizar")
    public String actualizarPerfil(){

        return "redirect:/home";
    }

}
