package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.ArtistaDto;
import com.listeny.listeny.models.Artista;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ArtistaMapper extends AbstractServiceMapper<Artista,ArtistaDto> {

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public ArtistaDto toDto(Artista entidad){
        final ArtistaDto dto = new ArtistaDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Artista toEntity(ArtistaDto dto){
        final Artista entidad = new Artista();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
