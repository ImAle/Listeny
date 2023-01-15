package com.listeny.listeny.service;

import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService {
    private final UsuarioRepository usuarioRepository;

    public UsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> findById(Long id){

        return this.usuarioRepository.findById(id);
    }


//    public Long getFollowers(Usuario usuario){
//
//        Optional id = findById(usuario.getId());
//        if (id.isPresent()){
//
//        }
//    }
}
