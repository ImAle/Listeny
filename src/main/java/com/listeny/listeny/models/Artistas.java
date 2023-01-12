package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Getter
@Setter
@Table(name = "Artistas")
public class Artistas {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "nombre", length = 45)
    private String nombre;

    @Column (name = "idUsuario")
    private int idUsuario;
}
