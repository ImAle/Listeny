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
    @Column (name = "nombre", length = 45)
    private String nombre;

    @Column (name = "idUsuario")
    private int idUsuario;

    @ManyToMany
    @JoinTable (name = "Artistas_canciones",
            joinColumns = @JoinColumn (name = "artistas_nombre"),
            inverseJoinColumns = @JoinColumn (name = "idCancion"))
    private List<Canciones> artistaCanciones = new ArrayList<>();

    public Artistas() {

    }

    public Artistas(String nombre, int idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Artistas{" +
                "nombre='" + nombre + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
