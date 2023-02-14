package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Rol;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioConPassDto {

    private Long id;
    private String nombreUsuario;
    private String clave;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date  fechaNacimiento;
    private char sexo;
    private String imagen;
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
                ", email='" + email + '\'' +
                ", rolDelUsuario=" + rolDelUsuario +
                '}';
    }
}
