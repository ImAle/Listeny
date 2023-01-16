package com.listeny.listeny.service;

import com.listeny.listeny.Dto.UsuariosDto;
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

    public Usuario findById(Long id){
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isPresent()){
            return usuario.get();
        }
        return ;
    }


    public int getFollowers(Usuario usuario){
        return usuario.getSeguidores().size();
    }
}
