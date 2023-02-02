package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.Dto.ListaDeCancionDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ListaDeCancionDto toDtoListaDeCanciones(List<Cancion> entidad){
        final ListaDeCancionDto dto = new ListaDeCancionDto();
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
