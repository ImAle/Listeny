package com.listeny.listeny.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "notificaciones")
public class Notificacion implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name="titulo", length = 100, nullable = false)
    private String titulo;

    public Notificacion() {

    }

    public Notificacion(Long id, String descripcion, String titulo) {
        this.id = id;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
