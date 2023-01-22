package com.listeny.listeny.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacionDto {

    private Long id;
    private String descripcion;
    private String titulo;


    public NotificacionDto(){

    }

    public NotificacionDto(Long id, String descripcion, String titulo) {
        this.id = id;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "NotificacionDto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
