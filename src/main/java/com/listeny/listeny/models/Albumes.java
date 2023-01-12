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
    private int id;

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
    Usuarios albumesUsuario;

    @ManyToMany(mappedBy = "usuarioAlbumesFavoritos")
    private List<Usuarios> albumFavoritoUsuarios = new ArrayList<>();

    @ManyToMany
    @JoinTable (name = "albumes_has_canciones",
            joinColumns = @JoinColumn (name = "albumes_id"),
            inverseJoinColumns = @JoinColumn (name = "canciones_id"))
    private List<Canciones> albumCanciones = new ArrayList<>();

    public Albumes() {

    }

    public Albumes(int id, int idPropietario, int reproducciones, String titulo, String imagen, String descripcion, Boolean publico, Usuarios albumesUsuario, List<Usuarios> albumFavoritoUsuarios, List<Canciones> albumCanciones) {
        this.id = id;
        this.idPropietario = idPropietario;
        this.reproducciones = reproducciones;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.publico = publico;
        this.albumesUsuario = albumesUsuario;
        this.albumFavoritoUsuarios = albumFavoritoUsuarios;
        this.albumCanciones = albumCanciones;
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
                ", albumesUsuario=" + albumesUsuario +
                ", albumFavoritoUsuarios=" + albumFavoritoUsuarios +
                ", albumCanciones=" + albumCanciones +
                '}';
    }
}
