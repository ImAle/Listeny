package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Artista;
import com.listeny.listeny.models.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancionDto {

    private Long id;
    private String imagen;
    private String titulo;
    private int duracion;
    private String descripcion;
    private Date fechaIncorporacion;
    private Boolean publica;
    private String url;
    private Categoria categoriaCancion;
    private List<Artista> artistaDeCancion;
    private List<Album> cancionEnAlbum;

    @Override
    public String toString() {
        return "CancionDto{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIncorporacion=" + fechaIncorporacion +
                ", publica=" + publica +
                ", url='" + url + '\'' +
                ", categoriaCancion=" + categoriaCancion +
                ", artistaDeCancion=" + artistaDeCancion +
                ", cancionEnAlbum=" + cancionEnAlbum +
                '}';
    }
}
