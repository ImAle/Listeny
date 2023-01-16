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
@Table(name="Usuario")
public class Usuario implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombreUsuario", length = 45, nullable = false)
    private String nombreUsuario;

    @Column(name="email", length = 60, nullable = false)
    private String email;

    @Column(name="clave", length = 100, nullable = false)
    private String clave;

    @Column(name="fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name="sexo", length = 1, nullable = false)
    private char sexo;

    @Column(name="imagen", length = 100)
    private String imagen;

    @Column(name="imagen_fondo", length = 100)
    private String imagenFondo;

    @Column(name="esArtista")
    private Boolean esArtista;


    @ManyToMany
    @JoinTable (name = "Favoritos_canciones",
    joinColumns = @JoinColumn (name="idUsuario"),
    inverseJoinColumns = @JoinColumn(name = "idFavorito"))
    private List<Cancion> cancionesFavoritas = new ArrayList<>();

    @ManyToMany
    @JoinTable (name="Favoritos_listas",
    joinColumns = @JoinColumn (name="idUsuario"),
    inverseJoinColumns = @JoinColumn(name="idLista"))
    private List<Lista> listasFavoritos = new ArrayList<>();

    @ManyToMany
    @JoinTable (name="Favoritos_albumes",
            joinColumns = @JoinColumn (name="idUsuario"),
            inverseJoinColumns = @JoinColumn(name="idAlbum"))
    private List<Album> albumesFavoritos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "seguidor",
            joinColumns = @JoinColumn(name = "idSeguidor", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idSeguido", referencedColumnName = "id"))
    private List<Usuario> seguidores = new ArrayList<>();

    @ManyToMany(mappedBy = "seguidores")
    private List<Usuario> seguidos = new ArrayList<>();

    @OneToMany(mappedBy = "propietarioLista")
    private List<Lista> propietarioListas = new ArrayList<>();

    @OneToMany(mappedBy = "propietarioCancion")
    private List<Cancion> propietarioCanciones = new ArrayList<>();

    @OneToMany(mappedBy = "propietarioAlbum")
    private List<Album> propietarioAlbumes = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(Long id, String nombreUsuario, String email, String clave, Date fechaNacimiento, char sexo, String imagen, String imagenFondo, Boolean esArtista) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.imagen = imagen;
        this.imagenFondo = imagenFondo;
        this.esArtista = esArtista;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo=" + sexo +
                ", imagen='" + imagen + '\'' +
                ", imagenFondo='" + imagenFondo + '\'' +
                ", esArtista=" + esArtista +
                '}';
    }
}
