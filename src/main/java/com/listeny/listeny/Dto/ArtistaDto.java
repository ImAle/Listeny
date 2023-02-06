package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistaDto {

    private String nombre;
    private int idUsuario;
    private List<Cancion> artistaCanciones = new ArrayList<>();

    @Override
    public String toString() {
        return "ArtistaDto{" +
                "nombre='" + nombre + '\'' +
                ", idUsuario=" + idUsuario +
                ", artistaCanciones=" + artistaCanciones +
                '}';
    }
}
