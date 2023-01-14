package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "canciones")
public class Cancion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario propietario;
    /*
    @Column(name = "idCategoria")
    private int idCategoria;
    */
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

/*
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categorias cancionesCategoria;

    @ManyToMany(mappedBy = "albumCanciones")
    private List<Album> cancionAlbumes = new ArrayList<>();

    @ManyToMany(mappedBy = "artistaCanciones")
    private List<Artistas> cancionArtistas = new ArrayList<>();

    @ManyToMany(mappedBy = "FavoritosCanciones")
    private List<Usuario> cancionesFavorito = new ArrayList<>();

    @ManyToMany(mappedBy = "listaCanciones")
    private List<Listas> cancionListas = new ArrayList<>();

    @OneToMany(mappedBy = "idCancion")
    List<Reproducciones> cancionReproducciones;
*/
    public Cancion() {

    }

    public Cancion(Long id, Long idPropietario, String imagen, String titulo, int duracion, String descripcion, Date fechaIncorporacion, Boolean publica, String url) {
        this.id = id;
        //this.idPropietario = idPropietario;
        //this.idCategoria = idCategoria;
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
                ", idPropietario=" + propietario.getId() +
                //", idCategoria=" + idCategoria +
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
