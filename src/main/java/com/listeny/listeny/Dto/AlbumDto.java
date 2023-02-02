package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {

    private Long id;
    private Usuario propietarioAlbum;
    private int reproducciones;
    private String titulo;
    private String imagen;
    private String descripcion;
    private Boolean publico;
    private List<Cancion> cancionesAlbum;
    private List<Usuario> favoritoAlbumUsuario = new ArrayList<>();

    public AlbumDto(Long id, String titulo, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "AlbumDto{" +
                "id=" + id +
                ", propietarioAlbum=" + propietarioAlbum +
                ", reproducciones=" + reproducciones +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", publico=" + publico +
                ", cancionesAlbum=" + cancionesAlbum +
                ", favoritoAlbumUsuario=" + favoritoAlbumUsuario +
                '}';
    }
}
