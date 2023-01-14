package com.listeny.listeny.services;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.repository.CancionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionSrvc {

    private final CancionRepository cancionrep;

    public CancionSrvc(CancionRepository cancionRepository) {
       this.cancionrep = cancionRepository;
   };

    public List<Cancion> getCanciones() {
       return cancionrep.listAll();
   }
}
