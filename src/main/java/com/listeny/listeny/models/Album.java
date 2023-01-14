package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "albumes")
public class Album {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @Id      // Al ser la columna "id" autoincremental, nos aseguramos que su valor ES ÚNICO, nunca se repite. Por tanto sirve como única PK
    /*
    @Column (name = "idPropietario")
    private int idPropietario;
    */
    @Column (name = "reproducciones")
    private int reproducciones; // Si la propiedad se llama igual que el campo, NO HACE FALTA la anotación @Column.

    @Column (name = "titulo", length = 45)
    private String titulo;

    @Column (name = "imagen", length = 100)
    private String imagen;

    @Column (name = "descripcion", length = 45)
    private String descripcion;

    @Column (name = "publico")
    private Boolean publico;

    @ManyToOne
    private Usuario propietario;    // esta propiedad contiene el enlace al objeto Usuario que es el propietario del album
    /*  Ahora, JPA sabe que hay una relación 1:n entre las entidades Usuario y Album. Cuando recupere los datos de
        un album, también recupera el objeto propietario con toda su información
     */

    /*
    @ManyToMany(mappedBy = "AlbumesFavoritos")
    private List<Usuario> albumFavorito = new ArrayList<>();

    @ManyToMany
    @JoinTable (name = "albumes_has_canciones",
            joinColumns = @JoinColumn (name = "albumes_id"),
            inverseJoinColumns = @JoinColumn (name = "canciones_id"))
    private List<Cancion> albumCanciones = new ArrayList<>();
    */
    public Album() {

    }

    public Album(int id, int reproducciones, String titulo, String imagen, String descripcion, Boolean publico) {
        this.id = id;
        //this.idPropietario = idPropietario;
        this.reproducciones = reproducciones;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.publico = publico;
    }

    @Override
    public String toString() {
        return "Albumes{" +
                "id=" + id +
                //", idPropietario=" + idPropietario +
                ", reproducciones=" + reproducciones +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publico=" + publico +
                '}';
    }
}
