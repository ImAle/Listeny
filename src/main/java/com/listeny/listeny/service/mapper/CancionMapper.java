package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.Dto.CancionesListadasDto;
import com.listeny.listeny.Dto.ListaDeCancionDto;
import com.listeny.listeny.models.Cancion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CancionMapper extends AbstractServiceMapper<Cancion, CancionDto>{

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public CancionDto toDto(Cancion entidad){
        final CancionDto dto = new CancionDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    public List<ListaDeCancionDto> toDtoListaDeCanciones(List<Cancion> entidad){

        List<ListaDeCancionDto> cancionesDto = new ArrayList<>();

        for ( Cancion cancion: entidad) {
            final ListaDeCancionDto dto = new ListaDeCancionDto();
            modelMapper.map(cancion, dto);
            cancionesDto.add(dto);
        }

        return cancionesDto;
    }

    public List<CancionesListadasDto> toDtoCancionesListadas(List<Cancion> entidad){
        List<CancionesListadasDto> cancionesDto = new ArrayList<>();

        for ( Cancion cancion: entidad) {
            final CancionesListadasDto dto = new CancionesListadasDto();
            modelMapper.map(cancion, dto);
            cancionesDto.add(dto);
        }

        return cancionesDto;
    }

    // Convertir DTO a entidad
    @Override
    public Cancion toEntity(CancionDto dto){
        final Cancion entidad = new Cancion();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
