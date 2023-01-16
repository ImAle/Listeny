package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;

public class UsuarioMapper {

    // Convertir identidad a DTO
    public static UsuariosDto toDto(Usuario usuario){
        final UsuariosDto dto = new UsuariosDto();
        dto.setId(usuario.getId());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setSoySeguido(usuario.getSeguidores().size());
        dto.setImagen(usuario.getImagen());
        dto.setImagenFondo(usuario.getImagenFondo());
        dto.setEmail(usuario.getEmail());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setSexo(usuario.getSexo());
        dto.setEsArtista(usuario.getEsArtista());
        dto.setListasFavoritos(usuario.getListasFavoritos());
        dto.setAlbumesFavoritos(usuario.getAlbumesFavoritos());
        dto.setCancionesFavoritas(usuario.getCancionesFavoritas());
        dto.setSoySeguidor(usuario.getSeguidos());
        return dto;
    }

    // Convertir DTO a identidad
    public static Usuario toIdentity(UsuariosDto usuariosDto){
        final Usuario usuario = new Usuario();
        usuario.setId(usuariosDto.getId());
        usuario.setNombreUsuario(usuariosDto.getNombreUsuario());
        usuario.setEmail(usuariosDto.getEmail());
        usuario.setClave(usuariosDto.getClave());
        usuario.setFechaNacimiento(usuariosDto.getFechaNacimiento());
        usuario.setSexo(usuariosDto.getSexo());
        usuario.setImagen(usuario.getImagen());
        usuario.setImagen(usuariosDto.getImagen());
        usuario.setImagenFondo(usuariosDto.getImagenFondo());
//        usuario.setListasFavoritos(usuariosDto.getListasFavoritos());
//        usuario.setAlbumesFavoritos(usuariosDto.getAlbumesFavoritos());
//        usuario.setCancionesFavoritas(usuariosDto.getCancionesFavoritas());
//        usuario.setSeguidor(usuariosDto.getSeguidos());
//        usuario.setSeguido(usuariosDto.getSeguidores().size());
        return usuario;
    } // ¿Añadir campos no propios de la tabla como CancionesFavoritas?
}
