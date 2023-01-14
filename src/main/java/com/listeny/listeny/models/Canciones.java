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
@Table(name = "canciones")
public class Canciones implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "idPropietario")
//    private Long idPropietario;

//    @Column(name = "idCategoria")
//    private int idCategoria;

    @Column(name = "imagen", length = 100)
    private String imagen;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "descripcion", length = 45)
    private String descripcion;

    @Column(name = "fecha_incorporacion")
    private Date fechaIncorporacion;

    @Column(name = "publica")
    private Boolean publica;

    @Column(name = "url", length = 200)
    private String url;

    @ManyToOne
    @JoinColumn(name = "idPropietario", referencedColumnName = "id")
    Usuarios propietarioCancion;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categorias cancionesCategoria;

    @ManyToMany(mappedBy = "albumCanciones")
    private List<Albumes> cancionAlbumes = new ArrayList<>();

    @ManyToMany(mappedBy = "artistaCanciones")
    private List<Artistas> cancionArtistas = new ArrayList<>();

    @ManyToMany(mappedBy = "FavoritosCanciones")
    private List<Usuarios> cancionesFavorito = new ArrayList<>();

    @ManyToMany(mappedBy = "listaCanciones")
    private List<Listas> cancionListas = new ArrayList<>();

    @OneToMany(mappedBy = "idCancion")
    List<Reproducciones> cancionReproducciones;

    public Canciones() {

    }

    public Canciones(Long id, Usuarios idPropietario, Categorias idCategoria, String imagen, String titulo, int duracion, String descripcion, Date fechaIncorporacion, Boolean publica, String url) {
        this.id = id;
        this.propietarioCancion = idPropietario;
        this.cancionesCategoria = idCategoria;
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
        return "Canciones{" +
                "id=" + id +
                ", idPropietario=" + propietarioCancion +
                ", idCategoria=" + cancionesCategoria +
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
