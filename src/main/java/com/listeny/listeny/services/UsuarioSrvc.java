package com.listeny.listeny.services;

import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioSrvc {

    private final UsuarioRepository usurep;

    public UsuarioSrvc(UsuarioRepository usuarioRepository) {
        this.usurep = usuarioRepository;
    }

    public List<Usuario> getUsuarios() {
        return usurep.findAll();
    }

}
