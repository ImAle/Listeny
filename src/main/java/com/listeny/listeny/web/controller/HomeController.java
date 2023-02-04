package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.LoginDto;
import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @Autowired
    CancionService cancionService;
    @Autowired
    ListaService listaService;
    @Autowired
    ReproduccionService reproduccionService;
    @Autowired
    AlbumService albumService;


    @GetMapping("/registro")
    public String registro(Model usuario){
        UsuarioConPassDto usuarioConPassDto = new UsuarioConPassDto();
        usuario.addAttribute("usuario", usuarioConPassDto);
        return "formulario_registro";
    }

    @GetMapping("/login")
    public String login(Model usuario, Model canciones){
        usuario.addAttribute("usuario", new LoginDto());
        canciones.addAttribute("canciones", cancionService.getMapper().toDtoListaDeCanciones(cancionService.getCancionesParaInicio()));
        return "index";
    }

    @GetMapping("/home")
    public String inicio(Model gustos, Model cancionesHistorial, Model listasMasReproducidas, Model albumesMasReproducidos, Model albumesRecomendados){

        //gustos.addAttribute("gustos", listaService.getMapper().toDtoListaDeLista(listaService.getListasPorGustos(idUsuario)));
        //cancionesHistorial.addAttribute("cancionesHistorial", cancionService.getMapper().toDtoListaDeCanciones(reproduccionService.getHistorialUltimasCancionesReproducidas(idUsuario)));
        listasMasReproducidas.addAttribute("listasMasReproducidas", listaService.getListasMasReproducidas());
        albumesMasReproducidos.addAttribute("albumesMasReproducidos", albumService.getMapper().toDtoListaDeAlbumes((albumService.getAlbumesRecomendados())));
        albumesRecomendados.addAttribute("albumesRecomendados", albumService.getAlbumesRecomendados());

        return "inicio_logueado";
    }


}
