package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.CategoriaDto;
import com.listeny.listeny.models.Categoria;
import org.modelmapper.ModelMapper;

public class CategoriaMapper extends AbstractServiceMapper<Categoria, CategoriaDto> {

    // Convertir entidad a DTO
    @Override
    public CategoriaDto toDto(Categoria entidad){
        final CategoriaDto dto = new CategoriaDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Categoria toEntity(CategoriaDto dto){
        final Categoria entidad = new Categoria();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);
        return entidad;
    }
}
