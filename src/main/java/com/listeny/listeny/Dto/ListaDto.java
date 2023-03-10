package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaDto {

    private Long id;
    private Usuario propietarioLista;
    private int reproducciones;
    private String nombre;
    private String imagen;
    private String descripcion;
    private Boolean publica;
    private Categoria listasCategoria;
    private List<Cancion> cancionesLista;

    @Override
    public String toString() {
        return "ListaDto{" +
                "id=" + id +
                ", propietarioLista=" + propietarioLista +
                ", reproducciones=" + reproducciones +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publica=" + publica +
                ", listasCategoria=" + listasCategoria +
                ", cancionesLista=" + cancionesLista +
                '}';
    }
}
