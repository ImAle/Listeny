package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.models.Categoria;
import com.listeny.listeny.models.Lista;
import jakarta.persistence.OneToMany;
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
    private Categoria idMadre;
    private List<Categoria> subcategorias;
    private List<Lista> categoriaListas;
    private List<Cancion> categoriaDeLaCancion;

    @Override
    public String toString() {
        return "CategoriaDto{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", idMadre=" + idMadre +
                ", subcategorias=" + subcategorias +
                ", categoriaListas=" + categoriaListas +
                ", categoriaDeLaCancion=" + categoriaDeLaCancion +
                '}';
    }
}
