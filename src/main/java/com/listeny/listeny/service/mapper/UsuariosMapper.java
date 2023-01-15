package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;

public class UsuariosMapper {

    // Convertir identidad a DTO
    public UsuariosDto toDto(Usuario usuario){
        final UsuariosDto dto = new UsuariosDto();
        dto.setId(usuario.getId());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setImagen(usuario.getImagen());
        dto.setImagenFondo(usuario.getImagenFondo());
        dto.setEmail(usuario.getEmail());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setSexo(usuario.getSexo());
        dto.setEsArtista(usuario.getEsArtista());


        return dto;
    }

    // Convertir DTO a identidad
//    public Usuario toIdentity(UsuariosDto usuariosDto){
//
//    }
}
