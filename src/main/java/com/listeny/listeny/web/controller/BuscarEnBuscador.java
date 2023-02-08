package com.listeny.listeny.web.controller;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.service.AlbumService;
import com.listeny.listeny.service.CancionService;
import com.listeny.listeny.service.ListaService;
import com.listeny.listeny.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buscador")
public class BuscarEnBuscador {

    @Autowired
    CancionService cancionService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ListaService listaService;
    @Autowired
    AlbumService albumService;


    @GetMapping("/canciones")
    public List<Cancion> buscarCancionesPorTitulo(@RequestParam("titulo") String titulo) {
        return cancionService.getRepo().findCancionsByTituloContaining(titulo);
    }

    @GetMapping("/listas")
    public List<Lista> buscarListasPorNombre(@RequestParam("nombre") String nombre) {
        return listaService.getRepo().findListasByNombreContaining(nombre);
    }

    @GetMapping("/albumes")
    public List<Album> buscarAlbumesPorTitulo(@RequestParam("titulo") String titulo) {
        return albumService.getRepo().findAlbumsByTituloContaining(titulo);
    }

    @GetMapping("/usuarios")
    public List<Usuario> buscarUsuariosPorNombreUsuario(@RequestParam("nombreUsuario") String nombreUsuario) {
        return usuarioService.getRepo().findUsuarioByNombreUsuarioContainingIgnoreCase(nombreUsuario);
    }

}
