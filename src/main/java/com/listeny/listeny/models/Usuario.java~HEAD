package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @OneToMany(mappedBy = "propietario")
    private Collection<Album> albumes;

    @OneToMany (mappedBy = "propietario")
    private List<Cancion> canciones;

    @ManyToMany
    @JoinTable(
            name="seguidores",
            joinColumns = @JoinColumn(name="id_seguidor"),inverseJoinColumns = @JoinColumn(name="id_seguido")
    )
    private List<Usuario> seguidos;

    @ManyToMany(mappedBy = "seguidos")
    private List<Usuario> seguidores;

    @OneToMany(mappedBy = "usuario")
    private List<Reproducciones> reproducciones;

    /*
    @ManyToMany
    @JoinTable (name = "Favoritos_canciones",
            joinColumns = @JoinColumn (name = "idUsuario"),
            inverseJoinColumns = @JoinColumn (name = "idFavorito"))
    private List<Cancion> FavoritosCanciones = new ArrayList<>();


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
        private List<Cancion> cancionesReproducidas;
    *
    * */

    public Usuario() {

    }

    public Usuario(int id, String nombreUsuario, String email, String clave, String alias, Date fechaNacimiento, char sexo, String imagen, String imagenFondo, Boolean esArtista) {
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



    public Collection<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(Collection<Album> albumes) {
        this.albumes = albumes;
    }
}
