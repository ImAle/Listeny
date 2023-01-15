package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Embeddable
@Entity
@IdClass(Seguidores.class)
public class Seguidores implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idSeguidor")
    private Usuarios seguidor;

    @Id
    @ManyToOne
    @JoinColumn(name = "idSeguido")
    private Usuarios seguido;

    public Seguidores(){

    }
    public Seguidores(Usuarios seguidor, Usuarios seguido) {
        this.seguidor = seguidor;
        this.seguido = seguido;
    }

    @Override
    public String toString() {
        return "Seguidores{" +
                "seguidor=" + seguidor +
                ", seguido=" + seguido +
                '}';
    }
}
