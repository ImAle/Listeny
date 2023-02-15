package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.ListaDeListaDto;
import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Lista;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaMapper extends AbstractServiceMapper<Lista, ListaDto>{

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public ListaDto toDto(Lista entidad){
        final ListaDto dto = new ListaDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    public List<ListaDeListaDto> toDtoListaDeLista(List<Lista> entidad){

        List<ListaDeListaDto> listaDto = new ArrayList<>();

        for (Lista lista: entidad) {
            ListaDeListaDto dto = new ListaDeListaDto();
            modelMapper.map(lista, dto);
            listaDto.add(dto);
        }
        return listaDto;
    }

    // Convertir DTO a entidad
    @Override
    public Lista toEntity(ListaDto dto){
        final Lista entidad = new Lista();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
