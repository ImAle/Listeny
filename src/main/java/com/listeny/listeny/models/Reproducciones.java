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
    @JoinColumn(name = "idUsuario" ,referencedColumnName = "id")
    Usuarios idUsuario;
    @Id
    @ManyToOne
    @JoinColumn(name = "idCancion" ,referencedColumnName = "id")
    Canciones idCancion;

    @Column(name = "reproducciones")
    private int reproducciones;

    @Column(name = "fecha_lastReproduccion")
    private Date fechaLastReproducciones;

    public Reproducciones() {

    }

    public Reproducciones(Usuarios idUsuario, Canciones idCancion, int reproducciones, Date fechaLastReproducciones) {
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
