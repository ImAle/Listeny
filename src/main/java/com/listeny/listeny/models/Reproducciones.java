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
    Usuarios reproduccionesUsuario;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "idCancion")
    Canciones reproduccionesCancion;

    @Column(name = "reproducciones")
    private int reproducciones;

    @Column(name = "fecha_lastReproduccion")
    private Date fechaLastReproducciones;

    public Reproducciones() {

    }

    public Reproducciones(Usuarios reproduccionesUsuario, Canciones reproduccionesCancion, int reproducciones, Date fechaLastReproducciones) {
        this.reproduccionesUsuario = reproduccionesUsuario;
        this.reproduccionesCancion = reproduccionesCancion;
        this.reproducciones = reproducciones;
        this.fechaLastReproducciones = fechaLastReproducciones;
    }

    @Override
    public String toString() {
        return "Reproducciones{" +
                "reproduccionesUsuario=" + reproduccionesUsuario +
                ", reproduccionesCancion=" + reproduccionesCancion +
                ", reproducciones=" + reproducciones +
                ", fechaLastReproducciones=" + fechaLastReproducciones +
                '}';
    }
}
