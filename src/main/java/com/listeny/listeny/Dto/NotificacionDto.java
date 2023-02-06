package com.listeny.listeny.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionDto {

    private Long id;
    private String descripcion;
    private String titulo;


    @Override
    public String toString() {
        return "NotificacionDto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
