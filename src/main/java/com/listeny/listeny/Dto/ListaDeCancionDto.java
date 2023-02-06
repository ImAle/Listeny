package com.listeny.listeny.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeCancionDto {

    private Long id;
    private String imagen;
    private String titulo;

    @Override
    public String toString() {
        return "ListaDeCancionDto{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
