package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.CategoriaDto;
import com.listeny.listeny.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
