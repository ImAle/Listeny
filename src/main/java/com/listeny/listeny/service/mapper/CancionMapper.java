package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.models.Cancion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CancionMapper extends AbstractServiceMapper<Cancion, CancionDto>{

    // Convertir entidad a DTO
    @Override
    public CancionDto toDto(Cancion entidad){
        final CancionDto dto = new CancionDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Cancion toEntity(CancionDto dto){
        final Cancion entidad = new Cancion();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
