package com.listeny.listeny.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancionesListadasDto {

    private Long id;
    private String imagen;
    private String titulo;
    private long duracion;
    private String descripcion;
    private Boolean publica;

}
