package com.listeny.listeny.web.controller;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BuscadorController {

    @Autowired
    ListaService listaService;
    @Autowired
    BuscadorService buscadorService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UserServiceImpl sessionService;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/buscador")
    public String buscador(Model model) throws Exception {
        model.addAttribute("favoritas", usuarioService.getListasFavoritas(sessionService.getSession().getId()));
        model.addAttribute("recomendadas", listaService.getListasRecomendadas());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        return "buscador";
    }

    @GetMapping("/buscador/{busqueda}")
    public String buscarPor(@ModelAttribute("busqueda") String busqueda, Model model) throws Exception {
        model.addAttribute("favoritas", usuarioService.getListasFavoritas(sessionService.getSession().getId()));
        model.addAttribute("canciones", buscadorService.buscarCancionesPorTitulo(busqueda));
        model.addAttribute("listas", buscadorService.buscarListasPorNombre(busqueda));
        model.addAttribute("albumes", buscadorService.buscarAlbumesPorTitulo(busqueda));
        model.addAttribute("usuarios", buscadorService.buscarUsuariosPorNombreUsuario(busqueda));
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        return "resultado_busqueda";
    }

    @GetMapping("/buscar")
    public String handleSearch(@RequestParam("buscar") String searchTerm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("buscar", searchTerm);
        return "redirect:/buscador/{buscar}";
    }

}

