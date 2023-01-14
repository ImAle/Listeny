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
public class Albumes {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column (name = "idPropietario")
    private int idPropietario;

    @Column (name = "reproducciones")
    private int reproducciones;

    @Column (name = "titulo", length = 45)
    private String titulo;

    @Column (name = "imagen", length = 100)
    private String imagen;

    @Column (name = "descripcion", length = 45)
    private String descripcion;

    @Column (name = "publico")
    private Boolean publico;

    @ManyToOne
    @JoinColumn (name = "idPropietario")
    Usuarios PropietarioAlbumes;

    @ManyToMany(mappedBy = "AlbumesFavoritos")
    private List<Usuarios> albumFavorito = new ArrayList<>();

    @ManyToMany
    @JoinTable (name = "albumes_has_canciones",
            joinColumns = @JoinColumn (name = "albumes_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "canciones_id", referencedColumnName = "id"))
    private List<Canciones> albumCanciones = new ArrayList<>();

    public Albumes() {

    }

    public Albumes(Long id, int idPropietario, int reproducciones, String titulo, String imagen, String descripcion, Boolean publico) {
        this.id = id;
        this.idPropietario = idPropietario;
        this.reproducciones = reproducciones;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.publico = publico;
    }

    @Override
    public String toString() {
        return "Albumes{" +
                "id=" + id +
                ", idPropietario=" + idPropietario +
                ", reproducciones=" + reproducciones +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publico=" + publico +
                '}';
    }


}
