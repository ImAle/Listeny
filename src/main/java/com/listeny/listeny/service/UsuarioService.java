package com.listeny.listeny.service;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.UsuarioRepository;
import com.listeny.listeny.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService extends AbstractBusinessService<Usuario, Long, UsuariosDto, UsuarioRepository, UsuarioMapper>{


    private final UsuarioRepository usuarioRepository;

    protected UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper mapper) {
        super(usuarioRepository, mapper);
    }

    public Boolean inicioSesion(UsuariosDto dto){
        Usuario usuario = usuarioRepository.findByUsername(dto.getNombreUsuario());
        if (Objects.equals(usuario.getClave(), dto.getPassword())){
            return true;
        }
        return false;
    }

    public void registro(UsuariosDto dto){
        // Comprobar si el nombre de usuario existe, si la contraseña es válida, si el email ya está usado
        Usuario usuario = usuarioRepository.findByUsername(dto.getNombreUsuario());
        comprobarPassword(dto.getPassword());

    }

    public Boolean comprobarPassword(String password){
        int upperCase = 0;
        int lowerCase = 0;
        int digits = 0;
        int special = 0;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCase++;
            } else if (Character.isLowerCase(ch)) {
                lowerCase++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isLetterOrDigit(ch)) {
                special++;
            }
        }

        if(upperCase > 0 && lowerCase > 0 && digits > 0 && special > 0) {
            return true;
        }
        return false;
    }


    public int getFollowers(Usuario usuario){
        return usuario.getSeguidores().size();
    }
}
