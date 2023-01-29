package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.service.ListaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListaController extends AbstractController<ListaDto> {

    private ListaService service;

    public ListaController(ListaService service) {
        this.service = service;
    }

    @GetMapping("/lista/{id}")
    public List<Cancion> vistaListaPorId(@PathVariable("id") Long id, Model model) throws Exception {
        List<Cancion> canciones = service.getCancionesDeLista(id);
        return canciones;
    }
}
