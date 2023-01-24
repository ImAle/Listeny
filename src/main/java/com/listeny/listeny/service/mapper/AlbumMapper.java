package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.AlbumDto;
import com.listeny.listeny.models.Album;
import org.modelmapper.ModelMapper;

public class AlbumMapper extends AbstractServiceMapper<Album, AlbumDto> {

    // Convertir entidad a DTO
    @Override
    public AlbumDto toDto(Album entidad){
        final AlbumDto dto = new AlbumDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Album toEntity(AlbumDto dto){
        final Album entidad = new Album();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
