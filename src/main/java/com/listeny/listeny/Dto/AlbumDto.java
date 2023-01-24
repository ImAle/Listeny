package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {

    private Long id;
    private int reproducciones;
    private String titulo;
    private String imagen;
    private String descripcion;
    private Boolean publico;
    private List<Cancion> cancionesAlbum;


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
