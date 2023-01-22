package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuariosDto {

    private Long id;
    private String nombreUsuario;
    private Integer soySeguido;
    private String imagen;
    private String imagenFondo;
    private String email;
    private Boolean esArtista;
    private List<Lista> listasFavoritos;
    private List<Album> albumesFavoritos;
    private List<Cancion> cancionesFavoritas;
    private List<Usuario> soySeguidor;


    public UsuariosDto(){

    }

    public UsuariosDto(Long id, String nombreUsuario, Integer soySeguido, String imagen, String imagenFondo, String email, Boolean esArtista, List<Lista> listasFavoritos, List<Album> albumesFavoritos, List<Cancion> cancionesFavoritas, List<Usuario> soySeguidor) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.soySeguido = soySeguido;
        this.imagen = imagen;
        this.imagenFondo = imagenFondo;
        this.email = email;
        this.esArtista = esArtista;
        this.listasFavoritos = listasFavoritos;
        this.albumesFavoritos = albumesFavoritos;
        this.cancionesFavoritas = cancionesFavoritas;
        this.soySeguidor = soySeguidor;
    }

    @Override
    public String toString() {
        return "UsuariosDto{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", soySeguido=" + soySeguido +
                ", imagen='" + imagen + '\'' +
                ", imagenFondo='" + imagenFondo + '\'' +
                ", email='" + email + '\'' +
                ", esArtista=" + esArtista +
                ", listasFavoritos=" + listasFavoritos +
                ", albumesFavoritos=" + albumesFavoritos +
                ", cancionesFavoritas=" + cancionesFavoritas +
                ", soySeguidor=" + soySeguidor +
                '}';
    }
}
