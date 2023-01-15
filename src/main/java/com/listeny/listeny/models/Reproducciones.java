package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Embeddable
@IdClass(Reproducciones.class)
public class Reproducciones implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    Usuarios idUsuario;
    @Id
    @ManyToOne
    @JoinColumn(name = "idCancion")
    Canciones idCancion;

    @Column(name = "reproducciones")
    private Long reproducciones;

    @Column(name = "fecha_lastReproduccion")
    private Date fechaLastReproducciones;

    public Reproducciones() {

    }

    public Reproducciones(Usuarios idUsuario, Canciones idCancion, Long reproducciones, Date fechaLastReproducciones) {
        this.idUsuario = idUsuario;
        this.idCancion = idCancion;
        this.reproducciones = reproducciones;
        this.fechaLastReproducciones = fechaLastReproducciones;
    }

    @Override
    public String toString() {
        return "Reproducciones{" +
                "reproduccionesUsuario=" + idUsuario +
                ", reproduccionesCancion=" + idCancion +
                ", reproducciones=" + reproducciones +
                ", fechaLastReproducciones=" + fechaLastReproducciones +
                '}';
    }
}
