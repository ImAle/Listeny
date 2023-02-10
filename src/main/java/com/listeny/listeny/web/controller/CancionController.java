package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.service.CancionService;
import com.listeny.listeny.service.CategoriaService;
import com.listeny.listeny.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class CancionController extends AbstractController<CancionDto>{

    @Autowired
    CancionService cancionService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/canciones/misCanciones")
    public String misCanciones(Model model, Long idUsuario) throws Exception {
        idUsuario=1L;
        List<Cancion> canciones = usuarioService.getUsuario(idUsuario).getPropietarioCanciones();
        model.addAttribute("canciones", cancionService.getMapper().toDtoCancionesListadas(canciones));
        model.addAttribute("nuevaCancion", new Cancion());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "subir_canciones";
    }

    @PostMapping("/canciones/misCanciones/subirCancion")
    public String subirCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion, @RequestParam("songFile") MultipartFile cancion, @RequestParam("songImage") MultipartFile imagen) throws IOException {
        Cancion guardarCancion = nuevaCancion;
        String urlDeLaCancion = cancionService.subirMp3(cancion);
        String urlDeLaImagen = cancionService.subirUnaImagen(imagen);
        guardarCancion.setUrl(urlDeLaCancion);
        guardarCancion.setImagen(urlDeLaImagen);
        cancionService.getRepo().save(guardarCancion);
        return "redirect:/cancion/misCanciones";
    }



}
