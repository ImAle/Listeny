package com.listeny.listeny.service;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscadorService {

    @Autowired
    CancionService cancionService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ListaService listaService;
    @Autowired
    AlbumService albumService;


    public List<Cancion> buscarCancionesPorTitulo(String titulo) {
        return cancionService.getRepo().findCancionsByTituloContaining(titulo);
    }

    public List<Lista> buscarListasPorNombre(String nombre) {
        return listaService.getRepo().findListasByNombreContaining(nombre);
    }

    public List<Album> buscarAlbumesPorTitulo(String titulo) {
        return albumService.getRepo().findAlbumsByTituloContaining(titulo);
    }

    public List<Usuario> buscarUsuariosPorNombreUsuario(String nombreUsuario) {
        return usuarioService.getRepo().findUsuarioByNombreUsuarioContainingIgnoreCase(nombreUsuario);
    }

}
