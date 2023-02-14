package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

//    @Column(name="esArtista")
//    private Boolean esArtista;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "rol", nullable = false)
    private Rol rolDelUsuario;

    @ManyToMany (fetch=FetchType.EAGER)
    @JoinTable (name = "Favoritos_canciones",
    joinColumns = @JoinColumn (name="idUsuario"),
    inverseJoinColumns = @JoinColumn(name = "idFavorito"))
    private List<Cancion> cancionesFavoritas = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="Favoritos_listas",
    joinColumns = @JoinColumn (name="idUsuario"),
    inverseJoinColumns = @JoinColumn(name="idLista"))
    private List<Lista> listasFavoritos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="Favoritos_albumes",
            joinColumns = @JoinColumn (name="idUsuario"),
            inverseJoinColumns = @JoinColumn(name="idAlbum"))
    private List<Album> albumesFavoritos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "seguidor",
            joinColumns = @JoinColumn(name = "idSeguidor", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idSeguido", referencedColumnName = "id"))
    private List<Usuario> sigueA = new ArrayList<>();

    @ManyToMany (mappedBy = "sigueA", fetch=FetchType.EAGER)
    private List<Usuario> seguidoPor;

    @OneToMany(mappedBy = "propietarioLista", fetch=FetchType.EAGER)
    private List<Lista> propietarioListas = new ArrayList<>();

    @OneToMany(mappedBy = "propietarioCancion", fetch=FetchType.EAGER)
    private List<Cancion> propietarioCanciones = new ArrayList<>();

    @OneToMany(mappedBy = "propietarioAlbum", fetch=FetchType.EAGER)
    private List<Album> propietarioAlbumes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch=FetchType.EAGER)
    private List<Reproduccion> usuarioReproduccion;


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
                ", rolDelUsuario=" + rolDelUsuario +
                '}';
    }
}
