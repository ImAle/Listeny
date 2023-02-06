package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDto {

    private Long id;
    private String nombreUsuario;
    private char sexo;
    private int seguidoPor;
    private String imagen;
    private String imagenFondo;
    private String email;
    private RolDto rolDelUsuario;
    private List<Lista> listasFavoritos;
    private List<Album> albumesFavoritos;
    private List<Cancion> cancionesFavoritas;
    private List<Usuario> sigueA;


    @Override
    public String toString() {
        return "UsuariosDto{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", sexo=" + sexo +
                ", seguidoPor=" + seguidoPor +
                ", imagen='" + imagen + '\'' +
                ", imagenFondo='" + imagenFondo + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rolDelUsuario +
                ", listasFavoritos=" + listasFavoritos +
                ", albumesFavoritos=" + albumesFavoritos +
                ", cancionesFavoritas=" + cancionesFavoritas +
                ", sigueA=" + sigueA +
                '}';
    }
}
