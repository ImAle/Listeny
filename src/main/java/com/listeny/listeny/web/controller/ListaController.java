package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListaController extends AbstractController<ListaDto> {

    @Autowired
    ListaService service;

    public ListaController(ListaService service) {
        this.service = service;
    }

    @GetMapping("/lista/{id}")
    public String vistaListaPorId(@PathVariable("id") Long id, Model model) throws Exception {
        Lista lista = service.getLista(id);
        model.addAttribute("lista", lista);
        return "lista";
    }

    @GetMapping("/categoria/{id}/listas")
    public String getListasPorCategoria(@PathVariable("id") Long idCategoria, Model model){

        model.addAttribute("listasDeLaCategoria",service.getListasByCategoria(idCategoria));
        return "playlists_por_categoria";
    }

}
