package com.listeny.listeny.services;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.repository.CancionRepository;
import com.listeny.listeny.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaSrvc {

    private final CategoriaRepository categrep;

    public CategoriaSrvc(CategoriaRepository categoriaRepository) {
        this.categrep = categoriaRepository;
    };

    public List<Categoria> getCategorias() {
        return categrep.listAll();
    }
}
