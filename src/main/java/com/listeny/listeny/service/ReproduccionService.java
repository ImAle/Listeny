package com.listeny.listeny.service;

import com.listeny.listeny.Dto.ReproduccionDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.models.Reproduccion;
import com.listeny.listeny.repository.ReproduccionRepository;
import com.listeny.listeny.service.mapper.ReproduccionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReproduccionService extends AbstractBusinessService<Reproduccion, Long, ReproduccionDto, ReproduccionRepository, ReproduccionMapper>{

    protected ReproduccionService(ReproduccionRepository reproduccionRepository, ReproduccionMapper mapper) {
        super(reproduccionRepository, mapper);
    }

    // Obtener la lista de canciones, de ella sacar las categorías, ver la categoría que más se repite (álbumes según tus preferencias)
//    public Categoria getCategoriaMasEscuchada (Long id){
//        Optional<Reproduccion> reproduccion = getRepo().findById(id);
//        if (reproduccion.isPresent()){
//            List<Cancion> CancionesEscuchadas = reproduccion.get().getCancion();
//        }
//    }
}
