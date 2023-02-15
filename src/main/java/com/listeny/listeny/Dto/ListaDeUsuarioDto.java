package com.listeny.listeny.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeUsuarioDto {

    private Long id;
    private String nombreUsuario;
    private String imagen;

    @Override
    public String toString() {
        return "ListaDeUsuarioDto{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
