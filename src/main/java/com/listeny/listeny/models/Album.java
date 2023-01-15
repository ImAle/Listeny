package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "albumes")
public class Album {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Usuario propietarioAlbum;

    @Column (name = "reproducciones")
    private int reproducciones;

    @Column (name = "titulo", length = 45, nullable = false)
    private String titulo;

    @Column (name = "imagen", length = 100)
    private String imagen;

    @Column (name = "descripcion", length = 45)
    private String descripcion;

    @Column (name = "publico")
    private Boolean publico;

    @ManyToMany
    @JoinTable (name = "albumes_has_canciones",
            joinColumns = @JoinColumn (name="albumes_id"),
            inverseJoinColumns = @JoinColumn(name = "canciones_id"))
    private List<Cancion> cancionesAlbum = new ArrayList<>();

    public Album() {

    }

    public Album(Long id, Usuario PropietarioAlbum, int reproducciones, String titulo, String imagen, String descripcion, Boolean publico) {
        this.id = id;
        this.propietarioAlbum = PropietarioAlbum;
        this.reproducciones = reproducciones;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.publico = publico;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", idPropietario=" + propietarioAlbum +
                ", reproducciones=" + reproducciones +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publico=" + publico +
                '}';
    }


}
