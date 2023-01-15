package com.listeny.listeny.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "notificaciones")
public class Notificaciones implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name="titulo", length = 100, nullable = false)
    private String titulo;

    public Notificaciones() {

    }

    public Notificaciones(Long id, String descripcion, String titulo) {
        this.id = id;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Notificaciones{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
