package com.listeny.listeny.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeAlbumDto {

    private Long id;
    private String titulo;
    private String imagen;

    @Override
    public String toString() {
        return "ListaDeAlbumDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
