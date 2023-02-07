package com.listeny.listeny.service;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.UsuarioRepository;
import com.listeny.listeny.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends AbstractBusinessService<Usuario, Long, UsuariosDto, UsuarioRepository, UsuarioMapper>{

    @Autowired
    CancionService cancionService;
    @Autowired
    ListaService listaService;
    @Autowired
    AlbumService albumService;
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

    public void seguirLista(Lista lista, Usuario usuario){
        usuario.getListasFavoritos().add(lista);
        lista.getFavoritaListaUsuario().add(usuario);
        getRepo().save(usuario);
        listaService.getRepo().save(lista);
    }
    public void dejarSeguirLista(Lista lista, Usuario usuario){
        usuario.getListasFavoritos().remove(lista);
        lista.getFavoritaListaUsuario().remove(usuario);
        getRepo().save(usuario);
        listaService.getRepo().save(lista);
    }

    public void seguirCancion(Cancion cancion, Usuario usuario){
         usuario.getCancionesFavoritas().add(cancion);
         cancion.getFavoritaCancionUsuario().add(usuario);
         getRepo().save(usuario);
         cancionService.getRepo().save(cancion);

    }

    public void dejarSeguirCancion(Cancion cancion, Usuario usuario){
        usuario.getCancionesFavoritas().remove(cancion);
        cancion.getFavoritaCancionUsuario().remove(usuario);
        getRepo().save(usuario);
        cancionService.getRepo().save(cancion);
    }

    public void seguirAlbum(Album album, Usuario usuario){
        usuario.getAlbumesFavoritos().add(album);
        album.getFavoritoAlbumUsuario().add(usuario);
        getRepo().save(usuario);
        albumService.getRepo().save(album);
    }

    public void dejarSeguirAlbum(Album album, Usuario usuario){
        usuario.getAlbumesFavoritos().remove(album);
        album.getFavoritoAlbumUsuario().remove(usuario);
        getRepo().save(usuario);
        albumService.getRepo().save(album);
    }

    public List<Lista> getListasFavoritas (Long id) throws Exception {
         Optional<Usuario> usuario = getRepo().findById(id);
         if (usuario.isPresent()){
             return usuario.get().getListasFavoritos();
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

    public Usuario encriptarClaveYGuardar(Usuario nuevoUsuario) {
        String passwd= nuevoUsuario.getClave();
        String encodedPassword = passwordEncoder.encode(passwd);
        nuevoUsuario.setClave(encodedPassword);
        getRepo().save(nuevoUsuario);
        return nuevoUsuario;
    }

    public void subirUnaImagen(MultipartFile file) throws IOException {
        subirImagen(file);
    };

    public void eliminarUnaImagen(String imagen){
        borrarImagen(imagen);
    }

    public void cambiarUnaImagen (MultipartFile file, String imagen) throws IOException {
        cambiarImagen(file, imagen);
    }
}
