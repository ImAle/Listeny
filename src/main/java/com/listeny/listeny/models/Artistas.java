package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Artistas")
public class Artistas {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "nombre", length = 45)
    private String nombre;

    @Column (name = "idUsuario")
    private int idUsuario;

    @ManyToMany
    @JoinTable (name = "Artistas_canciones",
            joinColumns = @JoinColumn (name = "idArtista"),
            inverseJoinColumns = @JoinColumn (name = "idCancion"))
    private List<Canciones> artistaCanciones = new ArrayList<>();

    public Artistas() {

    }

    public Artistas(int id, String nombre, int idUsuario, List<Canciones> artistaCanciones) {
        this.id = id;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.artistaCanciones = artistaCanciones;
    }

    @Override
    public String toString() {
        return "Artistas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idUsuario=" + idUsuario +
                ", artistaCanciones=" + artistaCanciones +
                '}';
    }
}
