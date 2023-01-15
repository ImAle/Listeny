package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Artista")
public class Artista {

    @Id
    @Column (name = "nombre", length = 45)
    private String nombre;

    @Column (name = "idUsuario")
    private int idUsuario;

    @ManyToMany
    @JoinTable (name = "Artistas_canciones",
            joinColumns = @JoinColumn (name = "artistas_nombre"),
            inverseJoinColumns = @JoinColumn (name = "idCancion"))
    private List<Cancion> artistaCanciones = new ArrayList<>();

    public Artista() {

    }

    public Artista(String nombre, int idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
