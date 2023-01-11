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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "idMadre")
    private int idMadre;

    @OneToMany(mappedBy = "categorias")
    List<Categorias> categorias;

}
