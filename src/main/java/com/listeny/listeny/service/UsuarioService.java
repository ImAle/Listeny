package com.listeny.listeny.service;

import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

//    public Usuario findById(Long id){
//        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
//        if (usuario.isPresent()){
//            return usuario.get();
//        }
//        return ;
//    }


    public int getFollowers(Usuario usuario){
        return usuario.getSeguidores().size();
    }
}
