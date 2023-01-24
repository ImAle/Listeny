package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Lista;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    private Long id;
    private String categoria;
    private List<Lista> categoriaListas;

    @Override
    public String toString() {
        return "CategoriaDto{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", categoriaListas=" + categoriaListas +
                '}';
    }
}
