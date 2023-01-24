package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuariosController extends AbstractController<UsuariosDto> {

    private UsuarioService service;


//    @GetMapping("/usuarios/{id}")
//    public String userById (@PathVariable("id") Long idUser, ModelMap interfaz){
//        // Pasamos usuario a dto
//        Optional<UsuariosDto> usuariosDto = Optional.of(UsuarioMapper.toDto(this.service.findById(idUser).get()));
//        if(usuariosDto.isPresent()){
//            // Lo metemos a una sesión
//            interfaz.addAttribute("userById", usuariosDto);
//            return "/usuarios/detalles";
//        }
//        return "/usuarios/noExiste";
//    }

    // Comprobar que datos se devuelven con JSON (@RestController)
//    @GetMapping("/usuarios/detalles/{id}")
//    public UsuariosDto userByIdJson (@PathVariable("id") Long idUser, ModelMap interfaz){
//        return UsuarioMapper.toDto(this.service.findById(idUser).get());
//    }

    @GetMapping("/index")
    public String login(HttpServletRequest request){
        UsuariosDto dto = new UsuariosDto();
        dto.setNombreUsuario(request.getParameter("usuario"));
        dto.setPassword(request.getParameter("password"));
        if (service.inicioSesion(dto)){
            return "inicio_logueado";
        }
        return "Usuario o contraseña incorrecta";
    }

    @PostMapping("/registro")
    public String registro(HttpServletRequest request){
        UsuariosDto dto = new UsuariosDto();
        dto.setNombreUsuario(request.getParameter("username"));
        dto.setPassword(request.getParameter("password"));
        dto.setEmail(request.getParameter("email"));
        dto.setFechaNacimiento(request.getParameter("fechaNacimiento"));
        dto.setSexo(request.getParameter("sexo"));
        dto.setEsArtista(request.getParameter("esArtista"));
        dto.setImagen(request.getParameter("imagen"));
        dto.setImagenFondo(request.getParameter("imagenFondo"));

    }
}
