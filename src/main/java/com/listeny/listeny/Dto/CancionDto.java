package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CancionDto {

    private Long id;
    private Usuario propietarioCancion;
    private String imagen;
    private String titulo;
    private int duracion;
    private String descripcion;
    private Date fechaIncorporacion;
    private Boolean publica;
    private String url;
    private Categoria categoriaCancion;
    // Me falta obtener Artista y Álbum al que pertenece, -> ¿hacer public esos atributos?
}
