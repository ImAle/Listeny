package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Albumes;
import com.listeny.listeny.models.Listas;
import com.listeny.listeny.models.Seguidores;
import com.listeny.listeny.models.Usuarios;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private List<Listas> listasFavoritos;
    private List<Albumes> albumesFavoritos;
    private List<Usuarios> soySeguidor;


    public UsuariosDto(){

    }

    public UsuariosDto(Long id, String nombreUsuario, Long soySeguido, String imagen, String imagenFondo, String email, String clave, Date fechaNacimiento, char sexo, Boolean esArtista, List<Listas> listasFavoritos, List<Albumes> albumesFavoritos, List<Usuarios> soySeguidor) {
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
