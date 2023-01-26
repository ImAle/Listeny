package com.listeny.listeny.service;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.repository.ListaRepository;
import com.listeny.listeny.service.mapper.ListaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaService extends AbstractBusinessService<Lista, Long, ListaDto, ListaRepository, ListaMapper>{

    public ListaService(ListaRepository repo, ListaMapper mapper) {
        super(repo, mapper);
    }

    public ListaDto getLista(Long idLista) throws Exception {
        Optional<ListaDto> listaDto = getRepo().findById(idLista).map(getMapper()::toDto);
        if(listaDto.isPresent()){
            return listaDto.get();
        }
        throw new Exception("La lista " + idLista + " no ha sido encontrada.");
    }

    public List<Cancion> getCancionesDeLista(Long idLista) throws Exception {
        Optional<ListaDto> listaDto = getRepo().findById(idLista).map(getMapper()::toDto);
        if(listaDto.isPresent()){
            return listaDto.get().getCancionesLista();
        }
        throw new Exception("La lista " + idLista + " no ha sido encontrada.");
    }



}
