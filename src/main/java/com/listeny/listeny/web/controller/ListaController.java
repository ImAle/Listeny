package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.service.ListaService;
import com.listeny.listeny.service.ReproduccionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListaController extends AbstractController<ListaDto> {

    private ListaService service;
    private ReproduccionService reproService;

    public ListaController(ListaService service) {
        this.service = service;
    }

    @GetMapping("/lista/{id}")
    public String vistaListaPorId(@PathVariable("id") Long id, Model model) throws Exception {
        ListaDto lista = service.getLista(id);
        model.addAttribute("lista", lista);
        return "lista";
    }

    @GetMapping("/buscador")
    public void gustosYCategorias(Long idUsuario, Model model){
        service.getListasByCategoria(reproService.getCategoriaMasEscuchada(idUsuario));

    }

}
