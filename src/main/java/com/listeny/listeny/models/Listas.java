package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "listas")
public class Listas implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_propietario")
    private int idPropietario;

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
    Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categorias categorias;


    public Listas(){

    }

    public Listas(int id, int idPropietario, int reproducciones, String nombre, String imagen, String descripcion, String color, Boolean publica, int idCategoria) {
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
