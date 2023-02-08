package com.listeny.listeny.web.controller;

import com.listeny.listeny.service.BuscadorService;
import com.listeny.listeny.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BuscadorController {

    @Autowired
    ListaService listaService;
    @Autowired
    BuscadorService buscadorService;

    @GetMapping("/buscador")
    public String buscador(Model model){
        model.addAttribute("recomendadas", listaService.getListasRecomendadas());
        return "buscador";
    }

    @GetMapping("/buscador/{busqueda}")
    public String buscarPor(@ModelAttribute("busqueda") String busqueda, Model model){
        model.addAttribute("canciones", buscadorService.buscarCancionesPorTitulo(busqueda));
        model.addAttribute("listas", buscadorService.buscarListasPorNombre(busqueda));
        model.addAttribute("albumes", buscadorService.buscarAlbumesPorTitulo(busqueda));
        model.addAttribute("usuarios", buscadorService.buscarUsuariosPorNombreUsuario(busqueda));
        return "resultado_busqueda";
    }

    @GetMapping("/buscar")
    public String handleSearch(@RequestParam("buscar") String searchTerm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("buscar", searchTerm);
        return "redirect:/buscador/{buscar}";
    }

}

