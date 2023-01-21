package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@IdClass(Reproduccion.class)
public class Reproduccion implements Serializable {

    @EmbeddedId
    ReproduccionPK id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idCancion")
    @JoinColumn(name = "idCancion")
    private Cancion cancion;

    @Column(name = "reproducciones")
    private Long reproducciones;

    @Column(name = "fecha_lastReproduccion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaLastReproducciones;

    public Reproduccion() {

    }

    public Reproduccion(Usuario usuario, Cancion cancion, Long reproducciones, Date fechaLastReproducciones) {
        this.usuario = usuario;
        this.cancion = cancion;
        this.reproducciones = reproducciones;
        this.fechaLastReproducciones = fechaLastReproducciones;
    }

    @Override
    public String toString() {
        return "Reproduccion{" +
                "reproduccionesUsuario=" + usuario +
                ", reproduccionesCancion=" + cancion +
                ", reproducciones=" + reproducciones +
                ", fechaLastReproducciones=" + fechaLastReproducciones +
                '}';
    }

}


@Embeddable
class ReproduccionPK implements Serializable {

    @Column(name="idUsuario")
    private Long idUsuario;

    @Column(name="idCancion")
    private Long idCancion;

}

