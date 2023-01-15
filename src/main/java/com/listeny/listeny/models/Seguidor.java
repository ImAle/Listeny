package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@Entity
@IdClass(Seguidor.class)
public class Seguidor implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idSeguidor")
    private Usuario seguidor;

    @Id
    @ManyToOne
    @JoinColumn(name = "idSeguido")
    private Usuario seguido;

    public Seguidor(){

    }
    public Seguidor(Usuario seguidor, Usuario seguido) {
        this.seguidor = seguidor;
        this.seguido = seguido;
    }

    @Override
    public String toString() {
        return "Seguidor{" +
                "seguidor=" + seguidor +
                ", seguido=" + seguido +
                '}';
    }
}
