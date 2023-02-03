package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Rol;
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
    private Rol rolDelUsuario;

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
                ", rolDelUsuario=" + rolDelUsuario +
                '}';
    }
}
