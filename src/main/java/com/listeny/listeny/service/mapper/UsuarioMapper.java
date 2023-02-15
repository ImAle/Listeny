package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.ListaDeUsuarioDto;
import com.listeny.listeny.Dto.LoginDto;
import com.listeny.listeny.Dto.UsuarioConPassDto;
import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.Usuario;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioMapper extends AbstractServiceMapper<Usuario, UsuariosDto>{

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public UsuariosDto toDto(Usuario entidad){
        final UsuariosDto dto = new UsuariosDto();
        if(entidad.getSeguidoPor().size() == 0){
            dto.setSeguidoPor(0);
        }else {
            dto.setSeguidoPor(entidad.getSeguidoPor().size());
        }

        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Usuario toEntity(UsuariosDto usuariosDto){
        final Usuario entidad = new Usuario();
        modelMapper.map(usuariosDto, entidad);
        return entidad;
    }

    public Usuario toEntity(UsuarioConPassDto dto){
        final Usuario entidad = new Usuario();
        modelMapper.map(dto, entidad);
        return entidad;
    }

    public Usuario toEntity(LoginDto login){
        final Usuario entidad = new Usuario();
        modelMapper.map(login, entidad);
        return entidad;
    }

    public List<ListaDeUsuarioDto> toDtoListaDto(List<Usuario> usuario){

        final List<ListaDeUsuarioDto> usuarioDto = new ArrayList<>();

        for (Usuario user: usuario) {
            ListaDeUsuarioDto dto = new ListaDeUsuarioDto();
            modelMapper.map(user, dto);
            usuarioDto.add(dto);
        }
        return usuarioDto;
    }
}
