package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "canciones")
public class Canciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idPropietario")
    private int idPropietario;

    @Column(name = "idCategoria")
    private int idCategoria;

    @Column(name = "imagen", length = 100)
    private String imagen;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "descripcion", length = 45)
    private String descripcion;

    @Column(name = "fecha_incorporacion")
    private Date fechaIncorporacion;

    @Column(name = "publica")
    private Boolean publica;

    @Column(name = "url", length = 200)
    private String url;

    @ManyToOne
    @JoinColumn(name = "idPropietario")
    Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    Categorias categorias;

    public Canciones(){

    }

    public Canciones(int id, int idPropietario, int idCategoria, String imagen, String titulo, int duracion, String descripcion, Date fechaIncorporacion, Boolean publica, String url) {
        this.id = id;
        this.idPropietario = idPropietario;
        this.idCategoria = idCategoria;
        this.imagen = imagen;
        this.titulo = titulo;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.fechaIncorporacion = fechaIncorporacion;
        this.publica = publica;
        this.url = url;
    }

}
