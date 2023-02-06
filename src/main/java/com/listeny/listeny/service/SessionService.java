//package com.listeny.listeny.service;
//
//import com.listeny.listeny.models.Usuario;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.http.HttpSession;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.stereotype.Service;
//
//import java.util.Enumeration;
//
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Service
//public class SessionService {
//
//    HttpSession session = new HttpSession() {
//        @Override
//        public long getCreationTime() {
//            return 0;
//        }
//
//        @Override
//        public String getId() {
//            return null;
//        }
//
//        @Override
//        public long getLastAccessedTime() {
//            return 0;
//        }
//
//        @Override
//        public ServletContext getServletContext() {
//            return null;
//        }
//
//        @Override
//        public void setMaxInactiveInterval(int i) {
//
//        }
//
//        @Override
//        public int getMaxInactiveInterval() {
//            return 0;
//        }
//
//        @Override
//        public Object getAttribute(String s) {
//            return null;
//        }
//
//        @Override
//        public Enumeration<String> getAttributeNames() {
//            return null;
//        }
//
//        @Override
//        public void setAttribute(String s, Object o) {
//
//        }
//
//        @Override
//        public void removeAttribute(String s) {
//
//        }
//
//        @Override
//        public void invalidate() {
//
//        }
//
//        @Override
//        public boolean isNew() {
//            return false;
//        }
//    };
//
//    public void crearSesionDelUsuario(Usuario usuario){
//        session.setAttribute("usuario", usuario);
//    }
//
//}
