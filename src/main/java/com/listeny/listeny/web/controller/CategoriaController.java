package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.CategoriaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoriaController extends AbstractController<CategoriaDto> {

    @Autowired
    CategoriaService categoriaService;


//    @GetMapping("/categoria/{id}/canciones")
//    public String getCancionDeCategoria(@PathVariable("id") Long id, Model model) throws Exception {
//        List<Cancion> cancionesPorCategoria = categoriaService.getCancionesPorCategoria(id);
//        model.addAttribute("cancionesPorCategoria", cancionesPorCategoria);
//        return "canciones_por_categoria";
//    }
}
