package com.listeny.listeny.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notificacion")
public class Notificacion implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name="titulo", length = 100, nullable = false)
    private String titulo;


    @Override
    public String toString() {
        return "Notificacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
