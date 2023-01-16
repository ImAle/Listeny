package com.listeny.listeny.service;

import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> findById(Long id){
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario;
    }


    public int getFollowers(Usuario usuario){
        return usuario.getSeguidores().size();
    }
}
