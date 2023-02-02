package com.listeny.listeny.service;


import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserDetailsService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;


//    public Usuario saveUser(Usuario nuevoUsuario, Usuario usuarioIntroducido) {
//        String passwd= usuarioIntroducido.getClave();
//        String encodedPassword = passwordEncoder.encode(passwd);
//        nuevoUsuario.setClave(encodedPassword);
//        usuarioRepository.save(nuevoUsuario);
//        return nuevoUsuario;
//    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Optional<Usuario> opt = usuarioRepository.findUserByEmail(email);

        if(opt.isEmpty())
            throw new UsernameNotFoundException("El usuario con email: " +email+ " no ha sido encontrado !");
        else {
            Usuario user = opt.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getClave(),
                    user.getRoles()
                            .stream()
                            .map(role-> new SimpleGrantedAuthority(role))
                            .collect(Collectors.toSet())
            );
        }
    }

}