package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import org.modelmapper.ModelMapper;

public class UsuarioMapper extends AbstractServiceMapper<Usuario, UsuariosDto>{

    // Convertir identidad a DTO
    @Override
    public UsuariosDto toDto(Usuario usuario){
        final UsuariosDto dto = new UsuariosDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(usuario, dto);
        return dto;
    }

    // Convertir DTO a identidad
    @Override
    public Usuario toEntity(UsuariosDto usuariosDto){
        final Usuario usuario = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(usuariosDto, usuario);
        return usuario;
    }
}
