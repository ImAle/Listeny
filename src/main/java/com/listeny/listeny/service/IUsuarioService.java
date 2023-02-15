package com.listeny.listeny.service;

import com.listeny.listeny.models.Usuario;

public interface IUsuarioService {
    public String getEncodedPassword(Usuario usuario);
}
