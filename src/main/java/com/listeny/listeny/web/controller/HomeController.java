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


    @GetMapping("/home")
    public String inicio(Model model){

        //model.addAttribute("gustos", listaService.getMapper().toDtoListaDeLista(listaService.getListasPorGustos(idUsuario)));
        //model.addAttribute("cancionesHistorial", cancionService.getMapper().toDtoListaDeCanciones(reproduccionService.getHistorialUltimasCancionesReproducidas(idUsuario)));
        model.addAttribute("listasMasReproducidas", listaService.getListasMasReproducidas());
        model.addAttribute("albumesMasReproducidos", albumService.getMapper().toDtoListaDeAlbumes((albumService.getAlbumesRecomendados())));
        model.addAttribute("albumesRecomendados", albumService.getAlbumesRecomendados());

        return "inicio_logueado";
    }


}
