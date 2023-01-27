package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper extends AbstractServiceMapper<Usuario, UsuariosDto>{

    // Convertir entidad a DTO
    @Override
    public UsuariosDto toDto(Usuario entidad){
        final UsuariosDto dto = new UsuariosDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }
    public UsuarioConPassDto toDtoRegistro(UsuarioConPassDto entidad){
        final UsuarioConPassDto dto = new UsuarioConPassDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Usuario toEntity(UsuariosDto usuariosDto){
        final Usuario entidad = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(usuariosDto, entidad);
        return entidad;
    }
}
