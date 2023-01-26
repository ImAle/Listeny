package com.listeny.listeny.service.mapper;

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
    public UsuariosDto toDtoPerfil(Usuario entidad){
        final UsuariosDto dto = new UsuariosDto();
        dto.setNombreUsuario(entidad.getNombreUsuario());
        dto.setImagen(entidad.getImagen());
        dto.setImagenFondo(entidad.getImagenFondo());
        dto.setSoySeguido(entidad.getSeguidores().size());

        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Usuario toEntity(UsuariosDto usuariosDto){
        final Usuario entidad = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(usuariosDto, entidad);
        entidad.setClave(usuariosDto.getPassword());
        return entidad;
    }
}
