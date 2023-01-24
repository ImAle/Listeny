package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Lista;
import org.modelmapper.ModelMapper;

public class ListaMapper extends AbstractServiceMapper<Lista, ListaDto>{

    // Convertir entidad a DTO
    @Override
    public ListaDto toDto(Lista entidad){
        final ListaDto dto = new ListaDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Lista toEntity(ListaDto dto){
        final Lista entidad = new Lista();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
