package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Embeddable
class ReproduccionesPK implements Serializable {

    @Column(name="idUsuario")
    private Integer idUsuario;

    @Column(name="idCancion")
    private Integer idCancion;
}

@Getter
@Setter
@Entity
@Table(name = "reproducciones")
public class Reproducciones implements Serializable {

    @EmbeddedId
    ReproduccionesPK id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idCancion")
    @JoinColumn(name = "idCancion")
    private Cancion cancion;

    @Column(name = "reproducciones")
    private int nroReprod;

    @Column(name = "fecha_lastReproduccion")
    private Date ultReprod;

    public Reproducciones() {

    }

    public Reproducciones(Usuario usu, Cancion can, int nroReprod, Date ultRepro) {
        this.usuario = usu;
        this.cancion = can;
        this.nroReprod = nroReprod;
        this.ultReprod = ultRepro;
    }

    @Override
    public String toString() {
        return "Reproducciones{" +
                "reproduccionesUsuario=" + usuario +
                ", reproduccionesCancion=" + cancion +
                ", reproducciones=" + nroReprod +
                ", fechaLastReproducciones=" + ultReprod +
                '}';
    }
}
