package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombreUsuario")
    private String nombreUsuario;

    @Column(name="email")
    private String email;

    @Column(name="clave")
    private String clave;

    @Column(name="alias")
    private String alias;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="sexo")
    private char sexo;

    @Column(name="imagen")
    private String imagen;

    @Column(name="imagen_fondo")
    private String imagenFondo;

    @Column(name="notificaciones_id")
    private int notificacionesId;

    @Column(name="esArtista")
    private Boolean esArtista;

    @ManyToOne
    @JoinColumn(name = "notificaciones_id")
    Notificaciones notificaciones;

    public Usuarios() {

    }

    public Usuarios(int id, String nombreUsuario, String email, String clave, String alias, Date fechaNacimiento, char sexo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.clave = clave;
        this.alias = alias;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Usuarios(int id, String nombreUsuario, String email, String clave, String alias, Date fechaNacimiento, char sexo, String imagen, String imagenFondo, int notificacionesId, Boolean esArtista) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.clave = clave;
        this.alias = alias;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.imagen = imagen;
        this.imagenFondo = imagenFondo;
        this.notificacionesId = notificacionesId;
        this.esArtista = esArtista;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", alias='" + alias + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo=" + sexo +
                ", imagen='" + imagen + '\'' +
                ", imagenFondo='" + imagenFondo + '\'' +
                ", notificacionesId=" + notificacionesId +
                ", esArtista=" + esArtista +
                '}';
    }
}
