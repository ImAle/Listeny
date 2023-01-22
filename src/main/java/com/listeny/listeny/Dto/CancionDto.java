package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Artista;
import com.listeny.listeny.models.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
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

    public CancionDto(){

    }

    public CancionDto(Long id, String imagen, String titulo, int duracion, String descripcion, Date fechaIncorporacion, Boolean publica, String url, Categoria categoriaCancion, List<Artista> artistaDeCancion, List<Album> cancionEnAlbum) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.fechaIncorporacion = fechaIncorporacion;
        this.publica = publica;
        this.url = url;
        this.categoriaCancion = categoriaCancion;
        this.artistaDeCancion = artistaDeCancion;
        this.cancionEnAlbum = cancionEnAlbum;
    }

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
