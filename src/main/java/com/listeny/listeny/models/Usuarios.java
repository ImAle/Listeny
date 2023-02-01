package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Usuarios")
public class Usuarios implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreUsuario", length = 45)
    private String nombreUsuario;

    @Column(name="email", length = 60)
    private String email;

    @Column(name="clave", length = 100)
    private String clave;

    @Column(name="alias", length = 45)
    private String alias;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="sexo", length = 1)
    private char sexo;

    @Column(name="imagen", length = 100)
    private String imagen;

    @Column(name="imagen_fondo", length = 100)
    private String imagenFondo;

    @Column(name="esArtista")
    private Boolean esArtista;

    @OneToMany (mappedBy = "idPropietario")
    List<Albumes> propietarioAlbumes;

    @ManyToMany
    @JoinTable (name = "Favoritos_albumes",
            joinColumns = @JoinColumn (name = "idUsuario"),
            inverseJoinColumns = @JoinColumn (name = "idFavorito"))
    private List<Albumes> AlbumesFavoritos = new ArrayList<>();

    @OneToMany (mappedBy = "idPropietario")
    List<Canciones> propietarioCanciones;

    @ManyToMany
    @JoinTable (name = "Favoritos_canciones",
            joinColumns = @JoinColumn (name = "idUsuario"),
            inverseJoinColumns = @JoinColumn (name = "idFavorito"))
    private List<Canciones> FavoritosCanciones = new ArrayList<>();

    @OneToMany(mappedBy = "seguidor")
    List<Seguidores> Seguidor;

    @OneToMany(mappedBy = "seguido")
    List<Seguidores> Seguido;

    @ManyToMany
    @JoinTable (name = "Favoritos_lista",
            joinColumns = @JoinColumn (name = "idUsuario"),
            inverseJoinColumns = @JoinColumn (name = "idLista"))
    private List<Listas> FavoritosListas = new ArrayList<>();

    @OneToMany(mappedBy = "listasUsuario")
    List<Listas> propietarioListas;

    @OneToMany(mappedBy = "idUsuario")
    List<Reproducciones> usuarioReproducciones;

    /*
    *  @JoinTable(name = "reproducciones",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_cancion"))
        private List<Canciones> cancionesReproducidas;
    *
    * */

    public Usuarios() {

    }

    public Usuarios(Long id, String nombreUsuario, String email, String clave, String alias, Date fechaNacimiento, char sexo, String imagen, String imagenFondo, Boolean esArtista) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.clave = clave;
        this.alias = alias;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.imagen = imagen;
        this.imagenFondo = imagenFondo;
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
                ", esArtista=" + esArtista +
                '}';
    }
}