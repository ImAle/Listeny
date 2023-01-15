package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "canciones")
public class Canciones implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Usuarios propietarioCancion;

    @Column(name = "imagen", length = 100)
    private String imagen;

    @Column(name = "titulo", length = 50, nullable = false)
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
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categorias categoriaCancion;

    public Canciones() {

    }

    public Canciones(Long id, Usuarios propietarioCancion, String imagen, String titulo, int duracion, String descripcion, Date fechaIncorporacion, Boolean publica, String url) {
        this.id = id;
        this.propietarioCancion = propietarioCancion;
        this.imagen = imagen;
        this.titulo = titulo;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.fechaIncorporacion = fechaIncorporacion;
        this.publica = publica;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Canciones{" +
                "id=" + id +
                ", propietarioCancion=" + propietarioCancion +
                ", imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIncorporacion=" + fechaIncorporacion +
                ", publica=" + publica +
                ", url='" + url + '\'' +
                '}';
    }
}
