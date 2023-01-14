package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/*
@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categorias {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoria", length = 45)
    private String categoria;

    @Column(name = "idMadre")
    private Long idMadre;

    @OneToMany(mappedBy = "cancionesCategoria")
    List<Canciones> categoriaCanciones;

    @ManyToOne
    @JoinColumn(name = "idMadre", referencedColumnName = "id")
    private Categorias idMadreCategoria;

    @OneToMany(mappedBy = "listasCategoria")
    List<Listas> categoriaListas;

    public Categorias() {

    }

    public Categorias(Long id, String categoria, Long idMadre) {
        this.id = id;
        this.categoria = categoria;
        this.idMadre = idMadre;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "Id=" + id +
                ", categoria='" + categoria + '\'' +
                ", idMadre=" + idMadre +
                '}';
    }
}
*/