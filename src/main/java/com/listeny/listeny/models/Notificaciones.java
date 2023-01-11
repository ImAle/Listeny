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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name="titulo")
    private String titulo;

    @Column(name="envio")
    private Date envio;



    public Notificaciones(){

    }

    public Notificaciones(int id, String descripcion, String titulo, Date envio) {
        this.id = id;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.envio = envio;
    }

    @Override
    public String toString() {
        return "Notificaciones{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", envio=" + envio +
                '}';
    }
}
