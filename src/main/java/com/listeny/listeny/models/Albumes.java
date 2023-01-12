package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn (name = "id_propietario")
    Usuarios usuarios;

    public Albumes() {

    }

    public Albumes(int id, int idPropietario, int reproducciones, String titulo, String imagen, String descripcion, Boolean publico, Usuarios usuarios) {
        this.id = id;
        this.idPropietario = idPropietario;
        this.reproducciones = reproducciones;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.publico = publico;
        this.usuarios = usuarios;
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
                ", usuarios=" + usuarios +
                '}';
    }
}
