package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.CategoriaDto;
import com.listeny.listeny.models.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoriaMapper extends AbstractServiceMapper<Categoria, CategoriaDto> {

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public CategoriaDto toDto(Categoria entidad){
        final CategoriaDto dto = new CategoriaDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Categoria toEntity(CategoriaDto dto){
        final Categoria entidad = new Categoria();
        modelMapper.map(dto, entidad);
        return entidad;
    }
}
