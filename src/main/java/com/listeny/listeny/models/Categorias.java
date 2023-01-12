package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categorias {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "categoria", length = 45)
    private String categoria;

    @Column(name = "idMadre")
    private int idMadre;

    @OneToMany(mappedBy = "cancionesCategoria")
    List<Canciones> categoriaCanciones;

    @OneToMany(mappedBy = "categorias")
    List<Categorias> categorias;

    @OneToMany(mappedBy = "listasCategoria")
    List<Listas> categoriaListas;

    public Categorias() {

    }

    public Categorias(int id, String categoria, int idMadre, List<Canciones> categoriaCanciones, List<Categorias> categorias, List<Listas> categoriaListas) {
        Id = id;
        this.categoria = categoria;
        this.idMadre = idMadre;
        this.categoriaCanciones = categoriaCanciones;
        this.categorias = categorias;
        this.categoriaListas = categoriaListas;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "Id=" + Id +
                ", categoria='" + categoria + '\'' +
                ", idMadre=" + idMadre +
                ", categoriaCanciones=" + categoriaCanciones +
                ", categorias=" + categorias +
                ", categoriaListas=" + categoriaListas +
                '}';
    }
}
