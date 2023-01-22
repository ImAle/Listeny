package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.models.Usuario;
import lombok.Getter;
import lombok.Setter;

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

    public ListaDto(){

    }

    public ListaDto(Long id, Usuario propietarioLista, int reproducciones, String nombre, String imagen, String descripcion, String color, Boolean publica, Categoria listasCategoria, List<Cancion> cancionesLista) {
        this.id = id;
        this.propietarioLista = propietarioLista;
        this.reproducciones = reproducciones;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.color = color;
        this.publica = publica;
        this.listasCategoria = listasCategoria;
        this.cancionesLista = cancionesLista;
    }

    @Override
    public String toString() {
        return "ListaDto{" +
                "id=" + id +
                ", propietarioLista=" + propietarioLista +
                ", reproducciones=" + reproducciones +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", publica=" + publica +
                ", listasCategoria=" + listasCategoria +
                ", cancionesLista=" + cancionesLista +
                '}';
    }
}
