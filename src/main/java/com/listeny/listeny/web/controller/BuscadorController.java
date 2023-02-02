package com.listeny.listeny.web.controller;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.AlbumRepository;
import com.listeny.listeny.repository.CancionRepository;
import com.listeny.listeny.repository.ListaRepository;
import com.listeny.listeny.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buscador")
public class BuscadorController {

    @Autowired
    private CancionRepository cancionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ListaRepository listaRepository;
    @Autowired
    private AlbumRepository albumRepository;


    @GetMapping("/canciones")
    public List<Cancion> buscarCancionesPorTitulo(@RequestParam("titulo") String titulo) {
        return cancionRepository.findByTituloContaining(titulo);
    }

    @GetMapping("/listas")
    public List<Lista> buscarListasPorNombre(@RequestParam("nombre") String nombre) {
        return listaRepository.findByNombreContaining(nombre);
    }

    @GetMapping("/albumes")
    public List<Album> buscarAlbumesPorTitulo(@RequestParam("titulo") String titulo) {
        return albumRepository.findByTituloContaining(titulo);
    }

    @GetMapping("/usuarios")
    public List<Usuario> buscarUsuariosPorNombreUsuario(@RequestParam("nombreUsuario") String nombreUsuario) {
        return usuarioRepository.findByUsernameConteining(nombreUsuario);
    }

}

