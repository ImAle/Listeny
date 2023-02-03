package com.listeny.listeny.service;

import com.google.common.collect.Lists;
import com.listeny.listeny.Dto.ReproduccionDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.repository.ReproduccionRepository;
import com.listeny.listeny.service.mapper.ReproduccionMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReproduccionService extends AbstractBusinessService<Reproduccion, Long, ReproduccionDto, ReproduccionRepository, ReproduccionMapper>{

    public ReproduccionService(ReproduccionRepository reproduccionRepository, ReproduccionMapper mapper) {
        super(reproduccionRepository, mapper);
    }

    // Historial de las últimas 5 canciones escuchadas por usuario
    public List<Cancion> getHistorialUltimasCancionesReproducidas (Long idUsuario){
        List<Cancion> ultimasReproducidas = Lists.newArrayList(getRepo().getUltimasCanciones(idUsuario));
        List<List<Cancion>> particionEnCinco = Lists.partition(ultimasReproducidas, 5);

        return particionEnCinco.get(1);
    }


    // Categoría más escuchada por usuario
    public Long getCategoriaMasEscuchada(Long idUsuario){
        List<Cancion> ultimasReproducidas = Lists.newArrayList(getRepo().getUltimasCanciones(idUsuario));
        List<Long> numeros = new ArrayList<>();
        for (Cancion cancion : ultimasReproducidas) {
            Categoria categoria = cancion.getCategoriaCancion();
            numeros.add(categoria.getId());
        }
        return numeroMasFrecuente(numeros.stream().mapToLong(Long::longValue).toArray());
    }

    // Sacar el número que más se repita de la lista
    public static Long numeroMasFrecuente(long[] numeros) {
        Map<Long, Integer> frecuencia = new HashMap<>();
        for (Long numero : numeros) {
            frecuencia.put(numero, frecuencia.getOrDefault(numero, 0) + 1);
        }
        long elMasFrecuente = 0;
        int maximaFrecuencia = 0;
        for (Map.Entry<Long, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maximaFrecuencia) {
                elMasFrecuente = entry.getKey();
                maximaFrecuencia = entry.getValue();
            }
        }
        return elMasFrecuente;
    }

}
