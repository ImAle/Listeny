package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "listas")
public class Listas implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name = "id_propietario")
    private Long idPropietario;

    @Column(name = "reproducciones")
    private int reproducciones;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "imagen",length = 100)
    private String imagen;

    @Column(name = "descripcion",length = 100)
    private String descripcion;

    @Column(name = "color", length = 15)
    private String color;

    @Column(name = "publica")
    private Boolean publica;

    @Column(name = "idCategoria")
    private int idCategoria;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    Usuarios listasUsuario;

    @ManyToMany(mappedBy = "FavoritosListas")
    private List<Usuarios> favoritosListas = new ArrayList<>();

    @ManyToMany
    @JoinTable (name = "listas_has_canciones",
            joinColumns = @JoinColumn (name = "listas_id"),
            inverseJoinColumns = @JoinColumn (name = "canciones_id"))
    private List<Canciones> listaCanciones = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categorias listasCategoria;

    public Listas() {

    }

    public Listas(Long id, Long idPropietario, int reproducciones, String nombre, String imagen, String descripcion, String color, Boolean publica, int idCategoria) {
        this.id = id;
        this.idPropietario = idPropietario;
        this.reproducciones = reproducciones;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.color = color;
        this.publica = publica;
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Listas{" +
                "id=" + id +
                ", idPropietario=" + idPropietario +
                ", reproducciones=" + reproducciones +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", publica=" + publica +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
