package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Artista")
public class Artista implements Serializable {

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


    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
