package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reproducciones")
public class Reproducciones implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "idUsuario")
    Usuarios usuario;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "idCancion")
    Canciones cancion;

    @Column(name = "reproducciones")
    private int reproducciones;

    @Column(name = "fecha_lastReproduccion")
    private Date fechaLastReproducciones;


    public Reproducciones() {

    }

    public Reproducciones(Usuarios usuario, Canciones cancion, int reproducciones, Date fechaLastReproducciones) {
        this.usuario = usuario;
        this.cancion = cancion;
        this.reproducciones = reproducciones;
        this.fechaLastReproducciones = fechaLastReproducciones;
    }

    @Override
    public String toString() {
        return "Reproducciones{" +
                "usuario=" + usuario +
                ", cancion=" + cancion +
                ", reproducciones=" + reproducciones +
                ", fechaLastReproducciones=" + fechaLastReproducciones +
                '}';
    }

}
