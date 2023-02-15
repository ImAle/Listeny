package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Usuario propietarioAlbum;

    @Column (name = "reproducciones")
    private int reproducciones;

    @Column (name = "titulo", length = 45, nullable = false)
    private String titulo;

    @Column (name = "imagen", length = 100)
    private String imagen;

    @Column (name = "descripcion", length = 45)
    private String descripcion;

    @Column (name = "publico", nullable = false)
    private Boolean publico = false;

    @ManyToMany
    @JoinTable (name = "albumes_has_canciones",
            joinColumns = @JoinColumn (name="albumes_id"),
            inverseJoinColumns = @JoinColumn(name = "canciones_id"))
    private List<Cancion> cancionesAlbum = new ArrayList<>();

    @ManyToMany(mappedBy = "albumesFavoritos")
    private List<Usuario> favoritoAlbumUsuario = new ArrayList<>();

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", idPropietario=" + propietarioAlbum +
                ", reproducciones=" + reproducciones +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publico=" + publico +
                '}';
    }


}
