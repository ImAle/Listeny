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
@IdClass(Reproduccion.class)
public class Reproduccion implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    Usuario idUsuario;
    @Id
    @ManyToOne
    @JoinColumn(name = "idCancion")
    Cancion idCancion;

    @Column(name = "reproducciones")
    private Long reproducciones;

    @Column(name = "fecha_lastReproduccion")
    private Date fechaLastReproducciones;

    public Reproduccion() {

    }

    public Reproduccion(Usuario idUsuario, Cancion idCancion, Long reproducciones, Date fechaLastReproducciones) {
        this.idUsuario = idUsuario;
        this.idCancion = idCancion;
        this.reproducciones = reproducciones;
        this.fechaLastReproducciones = fechaLastReproducciones;
    }

    @Override
    public String toString() {
        return "Reproduccion{" +
                "reproduccionesUsuario=" + idUsuario +
                ", reproduccionesCancion=" + idCancion +
                ", reproducciones=" + reproducciones +
                ", fechaLastReproducciones=" + fechaLastReproducciones +
                '}';
    }
}
