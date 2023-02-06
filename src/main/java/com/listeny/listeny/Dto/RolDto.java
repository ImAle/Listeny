package com.listeny.listeny.Dto;

import com.listeny.listeny.models.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RolDto {


    private int id;


    private String rol;

    private List<Usuario> usuario;

}
