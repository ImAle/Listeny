package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;

public class UsuariosMapper {

    // Convertir identidad a DTO
    public UsuariosDto toDto(Usuario usuario){
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
    public Usuario toIdentity(UsuariosDto usuariosDto){
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
        return usuario;
    }
}
