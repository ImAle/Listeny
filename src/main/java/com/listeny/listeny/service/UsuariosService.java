package com.listeny.listeny.service;

import com.listeny.listeny.models.Usuarios;
import com.listeny.listeny.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Optional<Usuarios> findById(Long id){

        return this.usuariosRepository.findById(id);
    }


//    public Long getFollowers(Usuarios usuario){
//
//        Optional id = findById(usuario.getId());
//        if (id.isPresent()){
//
//        }
//    }
}
