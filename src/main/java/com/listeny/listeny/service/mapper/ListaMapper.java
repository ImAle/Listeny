package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Lista;

public class ListaMapper {

    public ListaDto toDto(Lista lista){
        ListaDto listaDto = new ListaDto();
        listaDto.setId(lista.getId());
        listaDto.setPropietarioLista(lista.getPropietarioLista());
        listaDto.setReproducciones(lista.getReproducciones());
        listaDto.setNombre(lista.getNombre());
        listaDto.setImagen(lista.getImagen());
        listaDto.setDescripcion(lista.getDescripcion());
        listaDto.setColor(lista.getColor());
        listaDto.setPublica(lista.getPublica());
        listaDto.setListasCategoria(lista.getListasCategoria());
        listaDto.setCancionesLista(lista.getCancionesLista());
        return listaDto;
    }

    public Lista toEntity(ListaDto listaDto){
        Lista lista = new Lista();
        lista.setId(listaDto.getId());
        lista.setPropietarioLista(listaDto.getPropietarioLista());
        lista.setReproducciones(listaDto.getReproducciones());
        lista.setNombre(listaDto.getNombre());
        lista.setImagen(listaDto.getImagen());
        lista.setDescripcion(listaDto.getDescripcion());
        lista.setColor(listaDto.getColor());
        lista.setPublica(listaDto.getPublica());
//        lista.setListasCategoria(listaDto.getListasCategoria());
//        lista.setCancionesLista(listaDto.getCancionesLista());
        return lista;
    }
}
