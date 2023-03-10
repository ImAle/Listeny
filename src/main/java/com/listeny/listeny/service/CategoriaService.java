package com.listeny.listeny.service;

import com.listeny.listeny.Dto.CategoriaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.repository.CategoriaRepository;
import com.listeny.listeny.service.mapper.CategoriaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService extends AbstractBusinessService<Categoria, Long, CategoriaDto, CategoriaRepository, CategoriaMapper>{

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper mapper) {
        super(categoriaRepository, mapper);
    }

    public Categoria getCategoria(Long id) throws Exception {
        Optional<Categoria> categoria = this.getRepo().findById(id);
        if (categoria.isPresent()){
            return categoria.get();
        }
        throw new Exception("Esta categoria no existe");
    }

    public String getNombrePorId(Long id) throws Exception {
        Optional<Categoria> categoria = this.getRepo().findById(id);
        if (categoria.isPresent()){
            return categoria.get().getCategoria();
        }
        throw new Exception("Esta categoria no existe");
    }

    public List<Cancion> getCancionesPorCategoria(Long id) throws Exception {
        Optional<Categoria> categoria = this.getRepo().findById(id);
        if (categoria.isPresent()){
            return categoria.get().getCategoriaDeLaCancion();
        }
        throw new Exception("Esta categoria no existe");
    }

    public List<Categoria> getCategorias(){
        return getRepo().findAll();
    }

}
