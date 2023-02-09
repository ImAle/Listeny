//package com.listeny.listeny.Dto;
//
//import com.listeny.listeny.models.Usuario;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class CustomUserDetailsSec extends User implements UserDetails {
//
//        private static final long serialVersionUID = 1L;
//        private Usuario usuario;
//
//
//        public CustomUserDetailsSec(Usuario usuario) {
//            super(usuario.getNombreUsuario(), usuario.getClave(), usuario.getRolDelUsuario().getRol().toString());
//            this.usuario = usuario;
//        }
//
//        @Override
//        public Collection<GrantedAuthority> getAuthorities() {
//            return AuthorityUtils.commaSeparatedStringToAuthorityList(usuario.getRolDelUsuario().toString());
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
////        @Override
////        public boolean isEnabled() {
////            // just for example
////            return this.usuario.getActive() == true;
////        }
//
//        @Override
//        public String getUsername() {
//            return this.usuario.getNombreUsuario();
//        }
//
//        @Override
//        public String getPassword() {
//            return this.usuario.getClave();
//        }
//
//        // Just an example to put some additional Data to your logged in user
//
//        public String getUserDatabase() {
//            return "usertable" + (this.usuario.getId());
//        }
//
//
//    }
//}
//
//
//
