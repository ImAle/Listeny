package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.*;
import com.listeny.listeny.models.Rol;
import com.listeny.listeny.models.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolMapper extends AbstractServiceMapper<Rol, RolDto>{

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public RolDto toDto(Rol entidad){
        final RolDto dto = new RolDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Rol toEntity(RolDto  rolDto){
        final Rol entidad = new Rol();
        modelMapper.map(rolDto, entidad);
        return entidad;
    }

}
