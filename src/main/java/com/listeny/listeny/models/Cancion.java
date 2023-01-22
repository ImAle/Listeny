package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cancion")
public class Cancion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Usuario propietarioCancion;

    @Column(name = "imagen", length = 100)
    private String imagen;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "fecha_incorporacion")
    private Date fechaIncorporacion;

    @Column(name = "publica")
    private Boolean publica;

    @Column(name = "url", length = 200)
    private String url;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoriaCancion;

    @ManyToMany(mappedBy = "cancionesFavoritas")
    private List<Usuario> favoritaCancionUsuario = new ArrayList<>();

    @ManyToMany(mappedBy = "cancionesLista")
    private List<Lista> cancionEnLista = new ArrayList<>();

    @ManyToMany(mappedBy = "cancionesAlbum")
    private List<Album> cancionEnAlbum = new ArrayList<>();

    @ManyToMany(mappedBy = "artistaCanciones")
    private List<Artista> artistaDeCancion = new ArrayList<>();

    public Cancion() {

    }

    public Cancion(Long id, Usuario propietarioCancion, String imagen, String titulo, int duracion, String descripcion, Date fechaIncorporacion, Boolean publica, String url) {
        this.id = id;
        this.propietarioCancion = propietarioCancion;
        this.imagen = imagen;
        this.titulo = titulo;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.fechaIncorporacion = fechaIncorporacion;
        this.publica = publica;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", propietarioCancion=" + propietarioCancion +
                ", imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIncorporacion=" + fechaIncorporacion +
                ", publica=" + publica +
                ", url='" + url + '\'' +
                '}';
    }
}
