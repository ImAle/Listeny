package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UsuariosDto {

    private Long id;
    private String nombreUsuario;
    private Long soySeguido;
    private String imagen;
    private String imagenFondo;
    private String email;
    private String clave;
    private Date fechaNacimiento;
    private char sexo;
    private Boolean esArtista;
    private List<Lista> listasFavoritos;
    private List<Album> albumesFavoritos;
    private List<Usuario> soySeguidor;


    public UsuariosDto(){

    }

    public UsuariosDto(Long id, String nombreUsuario, Long soySeguido, String imagen, String imagenFondo, String email, String clave, Date fechaNacimiento, char sexo, Boolean esArtista, List<Lista> listasFavoritos, List<Album> albumesFavoritos, List<Usuario> soySeguidor) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.soySeguido = soySeguido;
        this.imagen = imagen;
        this.imagenFondo = imagenFondo;
        this.email = email;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.esArtista = esArtista;
        this.listasFavoritos = listasFavoritos;
        this.albumesFavoritos = albumesFavoritos;
        this.soySeguidor = soySeguidor;
    }


}
