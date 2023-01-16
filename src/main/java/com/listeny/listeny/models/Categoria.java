package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoria", length = 45)
    private String categoria;

    @OneToMany(mappedBy = "listasCategoria")
    private List<Lista> categoriaListas;

    @ManyToOne
    @JoinColumn(name = "id_madre")
    private Categoria idMadre;

    @OneToMany(mappedBy = "idMadre")
    private List<Categoria> subcategorias;


    public Categoria() {

    }

    public Categoria(Long id, String categoria, Categoria idMadre) {
        this.id = id;
        this.categoria = categoria;
        this.idMadre = idMadre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", idMadre=" + idMadre +
                '}';
    }
}
