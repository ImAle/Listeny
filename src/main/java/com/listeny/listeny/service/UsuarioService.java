package com.listeny.listeny.service;

import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.repository.UsuarioRepository;
import com.listeny.listeny.service.mapper.UsuarioMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends AbstractBusinessService<Usuario, Long, UsuariosDto, UsuarioRepository, UsuarioMapper>{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, UsuarioMapper mapper) {
        super(repo, mapper);
    }


    public UsuariosDto getUsuarioDto (Long idUsuario) throws Exception {
         Optional<UsuariosDto> usuariosDto = getRepo().findById(idUsuario).map(getMapper()::toDto);
         if (usuariosDto.isPresent()){
         return usuariosDto.get();
         }
        throw new Exception("Este usuario no existe");
    }

    public Usuario getUsuario(Long id) throws Exception {
        Optional<Usuario> entidad = this.getRepo().findById(id);
        if(entidad.isPresent()) {
            return entidad.get();
        }
        throw new Exception("Este usuario no existe");
    }

    public void seguirLista(Lista Lista, Usuario usuario){
        usuario.getListasFavoritos().add(Lista);
        getRepo().save(usuario);
    }
    public void dejarSeguirLista(Lista Lista, Usuario usuario){
        usuario.getListasFavoritos().remove(Lista);
        getRepo().save(usuario);
    }

    public void seguirCancion(Cancion cancion, Usuario usuario){
         usuario.getCancionesFavoritas().add(cancion);
         getRepo().save(usuario);
    }

    public void dejarSeguirCancion(Cancion cancion, Usuario usuario){
        usuario.getCancionesFavoritas().remove(cancion);
        getRepo().save(usuario);
    }

    public void seguirAlbum(Album album, Usuario usuario){
        usuario.getAlbumesFavoritos().add(album);
        getRepo().save(usuario);
    }

    public void dejarSeguirAlbum(Album album, Usuario usuario){
        usuario.getAlbumesFavoritos().remove(album);
        getRepo().save(usuario);
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

    public Usuario encriptarClaveYGuardar(Usuario nuevoUsuario, Usuario usuarioIntroducido) {
        String passwd= usuarioIntroducido.getClave();
        String encodedPassword = passwordEncoder.encode(passwd);
        nuevoUsuario.setClave(encodedPassword);
        getRepo().save(nuevoUsuario);
        return nuevoUsuario;
    }

}
