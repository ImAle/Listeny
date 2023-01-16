package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.models.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListaDto {

    private Long id;
    private Usuario propietarioLista;
    private int reproducciones;
    private String nombre;
    private String imagen;
    private String descripcion;
    private String color;
    private Boolean publica;
    private Categoria listasCategoria;
    private List<Cancion> cancionesLista;
    // Conseguir favoritosLista de usuarios aquí
}
