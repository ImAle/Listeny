package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Album;
import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDto {

    private Long id;
    private String nombreUsuario;
    private String password;
    private Date fechaNacimiento;
    private char sexo;
    private Integer soySeguido;
    private String imagen;
    private String imagenFondo;
    private String email;
    private Boolean esArtista;
    private List<Lista> listasFavoritos;
    private List<Album> albumesFavoritos;
    private List<Cancion> cancionesFavoritas;
    private List<Usuario> soySeguidor;


    @Override
    public String toString() {
        return "UsuariosDto{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", sexo=" + sexo +
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
