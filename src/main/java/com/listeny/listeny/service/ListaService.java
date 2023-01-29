package com.listeny.listeny.service;

import com.listeny.listeny.Dto.ListaDeListaDto;
import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.repository.ListaRepository;
import com.listeny.listeny.service.mapper.ListaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaService extends AbstractBusinessService<Lista, Long, ListaDto, ListaRepository, ListaMapper>{

    @Autowired
    public ListaService(ListaRepository repo, ListaMapper mapper) {
        super(repo, mapper);
    }

    public ListaDto getLista(Long idLista) throws Exception {
        Optional<ListaDto> listaDto = getRepo().findById(idLista).map(getMapper()::toDto);
        if(listaDto.isPresent()){
            return listaDto.get();
        }
        throw new Exception("La lista no existe");
    }

    public List<ListaDeListaDto> getListaDeLista (List<Long> id){
        List<ListaDeListaDto> listasPreparadas = new ArrayList<>();
        for (Long lista: id) {
            Optional<ListaDeListaDto> listaDto = getRepo().findById(lista).map(getMapper()::toDtoListaDeLista);
            listaDto.ifPresent(listasPreparadas::add);
        }
        return listasPreparadas;
    }

//    public List<ListaDeListaDto> getMinListas (int cuantasListas){
//        Random random = new Random();
//        List<Long> identificadores = new ArrayList<>();
//        int cuantos = 25; // Número de listas que queremos obtener
//        // Calculamos cuantas listas más son necesarias para llegar a 25
//        if (cuantasListas != 25){
//            cuantos = 25 - identificadores.size();
//        }
//        // Genero los números de las listas al azar
//        for (int i = 0; i < cuantos; i++) {
//            identificadores.add(random.nextLong());
//        }
//        // Las envío y obtengo de vuelta las listas que quiero enviar a la pantalla
//        List<ListaDeListaDto> listasPreparadas = getListaDeLista(identificadores);
//        // Si el número de listas que envio a la pantalla es menor al mínimo, recorro de nuevo este método
//        if (listasPreparadas.size() != 25){
//            getMinListas(listasPreparadas.size());
//        }
//
//        return listasPreparadas;
//    }

    public List<Cancion> getCancionesDeLista(Long idLista) throws Exception {
        Optional<ListaDto> listaDto = getRepo().findById(idLista).map(getMapper()::toDto);
        if(listaDto.isPresent()){
            return listaDto.get().getCancionesLista();
        } // Probablemente tenga que cambiarlo para que recoja la categoría de la lista
        throw new Exception("La lista no existe");
    }

}
