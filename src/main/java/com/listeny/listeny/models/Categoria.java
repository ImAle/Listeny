package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoria", length = 45)
    private String categoria;

    @OneToMany(mappedBy = "categoriaCancion")
    private List<Cancion> categoriaDeLaCancion;

    @OneToMany(mappedBy = "listasCategoria")
    private List<Lista> categoriaListas;

    @ManyToOne
    @JoinColumn(name = "id_madre")
    private Categoria idMadre;

    @OneToMany(mappedBy = "idMadre")
    private List<Categoria> subcategorias;


    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", idMadre=" + idMadre +
                '}';
    }
}
