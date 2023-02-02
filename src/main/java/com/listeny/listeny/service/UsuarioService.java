package com.listeny.listeny.service;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.repository.UsuarioRepository;
import com.listeny.listeny.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService extends AbstractBusinessService<Usuario, Long, UsuariosDto, UsuarioRepository, UsuarioMapper>{

     public UsuarioService(UsuarioRepository repo, UsuarioMapper mapper) {
        super(repo, mapper);
    }

//    public Boolean inicioSesion(UsuariosDto dto){
//        Usuario usuario = getRepo().findByUsername(dto.getNombreUsuario());
//        if (Objects.equals(usuario.getClave(), dto.getPassword())){
//            return true;
//        }
//        return false;
//    }
//
//    public void registro(UsuariosDto dto){
//        // Comprobar si el nombre de usuario existe, si la contraseña es válida, si el email ya está usado
//        Usuario usuario = getRepo().findByUsername(dto.getNombreUsuario());
//        comprobarPassword(dto.getPassword());
//
//    }
//
//    public Boolean comprobarPassword(String password){
//        int upperCase = 0;
//        int lowerCase = 0;
//        int digits = 0;
//        int special = 0;
//
//        if (password.length() < 8) {
//            return false;
//        }
//
//        for (int i = 0; i < password.length(); i++) {
//            char ch = password.charAt(i);
//            if (Character.isUpperCase(ch)) {
//                upperCase++;
//            } else if (Character.isLowerCase(ch)) {
//                lowerCase++;
//            } else if (Character.isDigit(ch)) {
//                digits++;
//            } else if (!Character.isLetterOrDigit(ch)) {
//                special++;
//            }
//        }
//
//        if(upperCase > 0 && lowerCase > 0 && digits > 0 && special > 0) {
//            return true;
//        }
//        return false;
//    }

    public UsuariosDto getUsuarioDto (Long idUsuario) throws Exception {
         Optional<UsuariosDto> usuariosDto = getRepo().findById(idUsuario).map(getMapper()::toDto);
         if (usuariosDto.isPresent()){
         return usuariosDto.get();
         }
        throw new Exception("Este usuario no existe");
    }

    public Usuario findUsuarioById(Long id) throws Exception {
        Optional<Usuario> entidad = this.getRepo().findById(id);
        if(entidad.isPresent()) {
            return entidad.get();
        }
        throw new Exception("Este usuario no existe");
    }

    public void seguirLista(Lista Lista, UsuariosDto usuario){
        usuario.getListasFavoritos().add(Lista);
        getRepo().save(getMapper().toEntity(usuario));
    }
    public void dejarSeguirLista(Lista Lista, UsuariosDto usuario){
        usuario.getListasFavoritos().remove(Lista);
        getRepo().save(getMapper().toEntity(usuario));
    }

    public void seguirCancion(Cancion cancion, UsuariosDto usuario){
         usuario.getCancionesFavoritas().add(cancion);
         getRepo().save(getMapper().toEntity(usuario));
    }

    public void dejarSeguirCancion(Cancion cancion, UsuariosDto usuario){
        usuario.getCancionesFavoritas().remove(cancion);
        getRepo().save(getMapper().toEntity(usuario));
    }

    public void seguirAlbum(Album album, UsuariosDto usuario){
        usuario.getAlbumesFavoritos().add(album);
        getRepo().save(getMapper().toEntity(usuario));
    }

    public void dejarSeguirAlbum(Album album, UsuariosDto usuario){
        usuario.getAlbumesFavoritos().remove(album);
        getRepo().save(getMapper().toEntity(usuario));
    }

    public List<Lista> getListasFavoritas (Long id) throws Exception {
         Optional<Usuario> usuario = getRepo().findById(id);
         if (usuario.isPresent()){
             return usuario.get().getListasFavoritos();
         }
        throw new Exception("Este usuario no existe");
    }

    public List<Cancion> getCancionesFavoritas (Long id) throws Exception {
        Optional<Usuario> usuario = getRepo().findById(id);
        if (usuario.isPresent()){
            return usuario.get().getCancionesFavoritas();
        }
        throw new Exception("Este usuario no existe");
    }

    public List<Album> getAlbumesFavoritos (Long id) throws Exception {
        Optional<Usuario> usuario = getRepo().findById(id);
        if (usuario.isPresent()){
            return usuario.get().getAlbumesFavoritos();
        }
        throw new Exception("Este usuario no existe");
    }

    public void seguirA(Usuario usuario, Usuario esteUsuario){
         usuario.getSeguidoPor().add(esteUsuario);
         esteUsuario.getSigueA().add(usuario);
         getRepo().save(usuario);
         getRepo().save(esteUsuario);
    }
    public void dejarDeSeguirA(Usuario usuario, Usuario esteUsuario){
        usuario.getSeguidoPor().remove(esteUsuario);
        esteUsuario.getSigueA().remove(usuario);
        getRepo().save(usuario);
        getRepo().save(esteUsuario);
    }

}
