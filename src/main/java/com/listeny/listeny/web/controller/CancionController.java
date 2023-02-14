package com.listeny.listeny.web.controller;

import com.listeny.listeny.Dto.CancionDto;
import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.service.CancionService;
import com.listeny.listeny.service.CategoriaService;
import com.listeny.listeny.service.UserServiceImpl;
import com.listeny.listeny.service.UsuarioService;
import com.listeny.listeny.util.FileUploadUtil;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    @Autowired
    UserServiceImpl sessionService;

    @GetMapping("/canciones/misCanciones")
    public String misCanciones(Model model) throws Exception {
        List<Cancion> canciones = sessionService.getSession().getPropietarioCanciones();
        model.addAttribute("canciones", cancionService.getMapper().toDtoCancionesListadas(canciones));
        model.addAttribute("nuevaCancion", new Cancion());
        model.addAttribute("nuevaLista", new Lista());
        model.addAttribute("nuevoAlbum", new Album());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "subir_canciones";
    }

    @PostMapping("/canciones/misCanciones/subirCancion")
    public String subirCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion, @RequestParam("songFile") MultipartFile cancion, @RequestParam("songImage") MultipartFile imagen) throws IOException, CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException {

        String fileName = StringUtils.cleanPath(cancion.getOriginalFilename());
        String uploadDir = "src/main/resources/static/canciones/";
        String uploadDirbbdd = "/canciones/";
        FileUploadUtil.saveFile(uploadDir, fileName, cancion);

        String stringname=imagen.getOriginalFilename();
        String imageName = StringUtils.cleanPath(imagen.getOriginalFilename());
        String uploadImageDir = "src/main/resources/static/imagenes/";
        String uploadDirImagebbdd = "/imagenes/";
        FileUploadUtil.saveFile(uploadImageDir, stringname, imagen);

        Cancion guardarCancion = nuevaCancion;

        guardarCancion.setUrl(uploadDirbbdd + fileName);
        guardarCancion.setImagen(uploadDirImagebbdd + imageName);
        guardarCancion.setPropietarioCancion(sessionService.getSession());

        cancionService.getRepo().save(guardarCancion);
        sessionService.getSession().getPropietarioCanciones().add(guardarCancion);

        return "redirect:/canciones/misCanciones";
    }



}
