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
public class Lista implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Usuario propietarioLista;

    @Column(name = "reproducciones")
    private int reproducciones;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "imagen", length = 100)
    private String imagen;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "color", length = 15)
    private String color;

    @Column(name = "publica")
    private Boolean publica;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria listasCategoria;


    @ManyToMany
    @JoinTable (name = "Listas_has_canciones",
            joinColumns = @JoinColumn (name="listas_id"),
            inverseJoinColumns = @JoinColumn(name = "canciones_id"))
    private List<Cancion> cancionesLista = new ArrayList<>();


    public Lista() {

    }

    public Lista(Long id, Usuario propietarioLista, int reproducciones, String nombre, String imagen, String descripcion, String color, Boolean publica) {
        this.id = id;
        this.propietarioLista = propietarioLista;
        this.reproducciones = reproducciones;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.color = color;
        this.publica = publica;
    }
}
