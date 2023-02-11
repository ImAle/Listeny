package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import com.listeny.listeny.repository.AlbumRepository;
import com.listeny.listeny.repository.UsuarioRepository;
import com.listeny.listeny.service.AlbumService;
import com.listeny.listeny.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListaController extends AbstractController<ListaDto> {

    @Autowired
    ListaService service;

    @Autowired
    AlbumService albumService;
    private final UsuarioRepository usuarioRepository;

    public ListaController(ListaService service,
                           UsuarioRepository usuarioRepository) {
        this.service = service;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/lista/{id}")
    public String vistaListaPorId(@PathVariable("id") Long id, Model model) throws Exception {
        Lista lista = service.getLista(id);
        Usuario usuario = lista.getPropietarioLista();
        List<Cancion> canciones = lista.getCancionesLista();
        model.addAttribute("lista", lista);
        model.addAttribute("canciones", canciones);
        model.addAttribute("nombreUsuario", usuario.getNombreUsuario());
        return "playlist_vista";
    }

    @GetMapping("/categoria/{id}/listas")
    public String getListasPorCategoria(@PathVariable("id") Long idCategoria, Model model){

        model.addAttribute("listasDeLaCategoria",service.getListasByCategoria(idCategoria));
        return "playlists_por_categorias";
    }

    @GetMapping("/crear/lista/{id}")
    public String crearLista(@ModelAttribute("id") Long id, Model model) throws Exception {
        Lista lista = service.getLista(id);
        model.addAttribute("lista", lista);
        return "crear_lista";
    }

    @GetMapping("/editar/lista/{id}")
    public String editarLista(@ModelAttribute("id") Long id, Model model) throws Exception {
        model.addAttribute("lista", service.getLista(id));
        return "crear_lista";
    }

    @PostMapping("/crear/lista")
    public String listaCreada(@ModelAttribute("lista") Lista lista, Model model){
        service.getRepo().save(lista);
        Long id = lista.getId();
        model.addAttribute("id", id);
        return "redirect:/crear/lista" + id;
    }

}
