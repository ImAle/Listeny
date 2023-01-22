package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlbumDto {

    private Long id;
    private int reproducciones;
    private String titulo;
    private String imagen;
    private String descripcion;
    private Boolean publico;
    private List<Cancion> cancionesAlbum;

    public AlbumDto(){

    }

    public AlbumDto(Long id, int reproducciones, String titulo, String imagen, String descripcion, Boolean publico, List<Cancion> cancionesAlbum) {
        this.id = id;
        this.reproducciones = reproducciones;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.publico = publico;
        this.cancionesAlbum = cancionesAlbum;
    }

    @Override
    public String toString() {
        return "AlbumDto{" +
                "id=" + id +
                ", reproducciones=" + reproducciones +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publico=" + publico +
                ", cancionesAlbum=" + cancionesAlbum +
                '}';
    }
}
