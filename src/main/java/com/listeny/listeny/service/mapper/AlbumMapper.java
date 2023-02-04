package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.AlbumDto;
import com.listeny.listeny.Dto.ListaDeAlbumDto;
import com.listeny.listeny.Dto.ListaDeCancionDto;
import com.listeny.listeny.models.Album;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumMapper extends AbstractServiceMapper<Album, AlbumDto> {


    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public AlbumDto toDto(Album entidad){
        final AlbumDto dto = new AlbumDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    public List<ListaDeAlbumDto> toDtoListaDeAlbumes(List<Album> entidad){

        List<ListaDeAlbumDto> albumesDto = new ArrayList<>();

        for (Album album: entidad) {
            ListaDeAlbumDto dto = new ListaDeAlbumDto();
            modelMapper.map(album, dto);
            albumesDto.add(dto);
        }
        return albumesDto;
    }

    // Convertir DTO a entidad
    @Override
    public Album toEntity(AlbumDto dto){
        final Album entidad = new Album();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
