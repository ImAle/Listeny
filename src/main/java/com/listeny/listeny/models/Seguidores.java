package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="seguidores")
public class Seguidores implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idSeguidor")
    Usuarios seguidor;

    @Id
    @ManyToOne
    @JoinColumn(name = "idSeguido")
    Usuarios seguido;

    public Seguidores() {

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
