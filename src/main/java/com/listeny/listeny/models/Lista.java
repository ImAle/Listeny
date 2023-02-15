package com.listeny.listeny.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lista")
public class Lista implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Usuario propietarioLista;

    @Column(name = "reproducciones")
    private int reproducciones;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "imagen", length = 100)
    private String imagen;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "publica")
    private Boolean publica = false;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria listasCategoria;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "Listas_has_canciones",
            joinColumns = @JoinColumn (name="listas_id"),
            inverseJoinColumns = @JoinColumn(name = "canciones_id"))
    private List<Cancion> cancionesLista = new ArrayList<>();

    @ManyToMany(mappedBy = "listasFavoritos")
    private List<Usuario> favoritaListaUsuario = new ArrayList<>();


    @Override
    public String toString() {
        return "Lista{" +
                "id=" + id +
                ", propietarioLista=" + propietarioLista +
                ", reproducciones=" + reproducciones +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publica=" + publica +
                '}';
    }
}
