package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Lista;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoriaDto {

    private Long id;
    private String categoria;
    private List<Lista> categoriaListas;

    public CategoriaDto(){

    }

    public CategoriaDto(Long id, String categoria, List<Lista> categoriaListas) {
        this.id = id;
        this.categoria = categoria;
        this.categoriaListas = categoriaListas;
    }

    @Override
    public String toString() {
        return "CategoriaDto{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", categoriaListas=" + categoriaListas +
                '}';
    }
}
