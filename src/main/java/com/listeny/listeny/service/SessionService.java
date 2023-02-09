//package com.listeny.listeny.service;
//
//import com.listeny.listeny.models.Usuario;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class SessionService {
//
//    @Autowired
//    UsuarioService usuarioService;
//
//    private Usuario usuario;
//
//    public SessionService() {
//        usuario = new Usuario();
//    }
//
////    @PostConstruct
////    public void init() {
////        Authentication auth = SecurityContextHolder
////                .getContext()
////                .getAuthentication();
////        UserDetails userDetail = (UserDetails) auth.getPrincipal();
////        usuario = this.usuarioService.getUsuario(userDetail.getPassword());
////        System.out.println(usuario);
////        System.out.println(usuario.getNombreUsuario());
////    }
//}
