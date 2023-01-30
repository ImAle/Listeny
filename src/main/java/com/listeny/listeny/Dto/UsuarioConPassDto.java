package com.listeny.listeny.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioConPassDto {

    private Long id;
    private String nombreUsuario;
    private String clave;
    private Date fechaNacimiento;
    private char sexo;
    private String imagen;
    private String imagenFondo;
    private String email;
    private Boolean esArtista;

    @Override
    public String toString() {
        return "UsuarioConPassDto{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", clave='" + clave + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo=" + sexo +
                ", imagen='" + imagen + '\'' +
                ", imagenFondo='" + imagenFondo + '\'' +
                ", email='" + email + '\'' +
                ", esArtista=" + esArtista +
                '}';
    }
}