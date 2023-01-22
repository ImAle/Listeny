package com.listeny.listeny.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categoria", length = 45)
    private String categoria;

    @Column(name = "idMadre")
    private Integer idMadre;

    @OneToMany(mappedBy = "categoria")
    List<Cancion> canciones;

/*
    @ManyToOne
    @JoinColumn(name = "idMadre", referencedColumnName = "id")
    private Categoria idMadreCategoria;
*/


    public Categoria() {

    }

    public Categoria(Integer id, String categoria, Integer idMadre) {
        this.id = id;
        this.categoria = categoria;
        this.idMadre = idMadre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getIdMadre() {
        return idMadre;
    }

    public void setIdMadre(Integer idMadre) {
        this.idMadre = idMadre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "Id=" + id +
                ", categoria='" + categoria + '\'' +
                ", idMadre=" + idMadre +
                '}';
    }
}
