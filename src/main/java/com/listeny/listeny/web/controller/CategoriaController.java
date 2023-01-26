package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.CategoriaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoriaController extends AbstractController<CategoriaDto> {

    private CategoriaService service;

    @GetMapping("/categoria/{nombre}")
    public List<Cancion> getCancionDeCategoria(@PathVariable("nombre") String nombre, Long id, Model model) throws Exception {
        List<Cancion> listaPorCategoria = this.service.getListaPorCategoria(id);
        return listaPorCategoria;
    }
}
