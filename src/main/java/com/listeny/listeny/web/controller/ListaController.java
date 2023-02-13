package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class ListaController extends AbstractController<ListaDto> {
    @Autowired
    ListaService service;
    @Autowired
    AlbumService albumService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    UserServiceImpl sessionService;

    public ListaController(ListaService service) {
        this.service = service;
    }

    @GetMapping("/lista/{id}")
    public String vistaListaPorId(@PathVariable("id") Long id, Model model) throws Exception {
        Lista lista = service.getLista(id);
        Usuario usuario = lista.getPropietarioLista();
        List<Cancion> canciones = lista.getCancionesLista();
        model.addAttribute("lista", lista);
        model.addAttribute("canciones", canciones);
        model.addAttribute("nombreUsuario", usuario.getNombreUsuario());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "playlist_vista";
    }

    @GetMapping("/categoria/{id}/listas")
    public String getListasPorCategoria(@PathVariable("id") Long idCategoria, Model model){
        model.addAttribute("listasDeLaCategoria",service.getListasByCategoria(idCategoria));
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "playlists_por_categorias";
    }

    @GetMapping("/eliminar/lista/{id}")
    public String eliminarLista(@PathVariable("id") Long id) throws Exception {
        Lista lista = service.getLista(id);
        service.getRepo().delete(lista);
        return "redirect:/home";
    }

    @GetMapping("/crear/lista/{id}")
    public String crearLista(@PathVariable("id") Long id, Model model) throws Exception {
        Lista lista = service.getLista(id);
        List<Cancion> canciones = lista.getCancionesLista();
        model.addAttribute("lista", lista);
        model.addAttribute("canciones", canciones);
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        return "crear_lista";
    }

    @GetMapping("/editar/lista/{id}")
    public String editarLista(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("lista", service.getLista(id));
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "crear_lista";
    }

    @PostMapping("/editar/lista/{id}")
    public String listaEditada(@PathVariable("id") Long id, @ModelAttribute("lista") Lista lista) throws Exception {
        Lista listaDelId = service.getLista(id);
        System.out.println("holaaaaaa");
        System.out.println(lista);
        if(lista.getNombre() != null && !Objects.equals(lista.getNombre(), "")){
            listaDelId.setNombre(lista.getNombre());
        }
        if(lista.getImagen() != null){
            listaDelId.setImagen(lista.getImagen());
        }
        if(lista.getDescripcion() != null && !Objects.equals(lista.getDescripcion(), "")){
            listaDelId.setDescripcion(lista.getDescripcion());
        }
        if(lista.getPublica() != null) {
            listaDelId.setPublica(lista.getPublica());
        }
        listaDelId.setListasCategoria(lista.getListasCategoria());
        service.getRepo().save(listaDelId);
        return "redirect:/editar/lista/" + id;
    }

    @PostMapping("/crear/lista")
    public String listaCreada(@ModelAttribute("lista") Lista lista, Model model){
        lista.setPropietarioLista(sessionService.getSession());
        service.getRepo().save(lista);
        Long id = lista.getId();
        model.addAttribute("id", id);
        return "redirect:/crear/lista/" + id;
    }

    @PostMapping(value = {"/crear/listaNueva", "/crear/albumNuevo"})
    public String crearListaOrAlbum(@RequestParam("tipo") String tipo, @ModelAttribute("nuevaLista") Lista nuevaLista,
                                    Model model) throws Exception {

        System.out.println(sessionService.getSession());
        System.out.println("holaaaaaaa");
        System.out.println(nuevaLista);
        if (tipo.equals("playlist")) {
            nuevaLista.setPropietarioLista(sessionService.getSession());
            service.getRepo().save(nuevaLista);
            Long id = nuevaLista.getId();
            model.addAttribute("id", id);
            return "redirect:/crear/lista/" + id;

        } else {
            Album nuevoAlbum = new Album();
            nuevoAlbum.setTitulo(nuevaLista.getNombre());
            nuevoAlbum.setCancionesAlbum(nuevaLista.getCancionesLista());
            nuevoAlbum.setPropietarioAlbum(sessionService.getSession());
            albumService.getRepo().save(nuevoAlbum);
            Long id = nuevoAlbum.getId();
            model.addAttribute("id", id);
            return "redirect:/crear/album/" + id;
        }
    }

}
