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
    private Long id;

    @Column(name = "categoria", length = 45)
    private String categoria;

    @OneToMany(mappedBy = "listasCategoria")
    private List<Listas> categoriaListas;

    @ManyToOne
    @JoinColumn(name = "id_madre")
    private Categorias idMadre;

    @OneToMany(mappedBy = "idMadre")
    private List<Categorias> subcategorias;


    public Categorias() {

    }

    public Categorias(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }
}
