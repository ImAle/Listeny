package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.ListaDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.service.AlbumService;
import com.listeny.listeny.service.CategoriaService;
import com.listeny.listeny.service.ListaService;
import com.listeny.listeny.service.UsuarioService;
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

    @Autowired
    CategoriaService categoriaService;
    @Autowired
    UsuarioService usuarioService;

    public ListaController(ListaService service) {
        this.service = service;
    }

    @GetMapping("/lista/{id}")
    public String vistaListaPorId(@PathVariable("id") Long id, Model model) throws Exception {
        Lista nuevaLista = new Lista();
        Lista lista = service.getLista(id);
        Usuario usuario = lista.getPropietarioLista();
        List<Cancion> canciones = lista.getCancionesLista();
        model.addAttribute("lista", lista);
        model.addAttribute("canciones", canciones);
        model.addAttribute("nombreUsuario", usuario.getNombreUsuario());
        model.addAttribute("nuevaLista", nuevaLista);
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
        List<Cancion> canciones = lista.getCancionesLista();
        model.addAttribute("lista", lista);
        model.addAttribute("canciones", canciones);
        return "crear_lista";
    }

    @GetMapping("/editar/lista/{id}")
    public String editarLista(@ModelAttribute("id") Long id, Model model) throws Exception {
        model.addAttribute("lista", service.getLista(id));
        return "crear_lista";
    }

//    @PostMapping("/crear/lista")
//    public String listaCreada(@ModelAttribute("lista") Lista lista, Model model){
//        service.getRepo().save(lista);
//        Long id = lista.getId();
//        model.addAttribute("id", id);
//        return "redirect:/crear/lista" + id;
//    }

    @PostMapping(value = {"/crear/lista", "/crear/album"})
    public String crearListaOrAlbum(@RequestParam("titulo") String titulo, @RequestParam("tipo") String tipo,
                                    @ModelAttribute("nuevaLista") Lista nuevaLista,
                                    Model model) throws Exception {
        if (tipo.equals("playlist")) {
            System.out.println("holaaaaaaa");
            System.out.println(nuevaLista);
            nuevaLista.setNombre(titulo);
            service.getRepo().save(nuevaLista);
            Long id = nuevaLista.getId();
            model.addAttribute("id", id);
            return "redirect:/crear/lista/" + id;

        } else {
            Album nuevoAlbum = new Album();
            nuevoAlbum.setTitulo(titulo);
            nuevoAlbum.setCancionesAlbum(nuevaLista.getCancionesLista());
            //nuevoAlbum.setPropietarioAlbum(usuarioService.getUsuario(1L));
            albumService.getRepo().save(nuevoAlbum);
            Long id = nuevoAlbum.getId();
            model.addAttribute("id", id);
            return "redirect:/crear/album/" + id;
        }
    }

}
