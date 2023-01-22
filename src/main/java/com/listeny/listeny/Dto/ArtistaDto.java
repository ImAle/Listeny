package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ArtistaDto {

    private String nombre;
    private int idUsuario;
    private List<Cancion> artistaCanciones = new ArrayList<>();


    public ArtistaDto(){

    }
    public ArtistaDto(String nombre, int idUsuario, List<Cancion> artistaCanciones) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.artistaCanciones = artistaCanciones;
    }
    @Override
    public String toString() {
        return "ArtistaDto{" +
                "nombre='" + nombre + '\'' +
                ", idUsuario=" + idUsuario +
                ", artistaCanciones=" + artistaCanciones +
                '}';
    }
}
