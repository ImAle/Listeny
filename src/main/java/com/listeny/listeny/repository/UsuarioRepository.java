package com.listeny.listeny.repository;

import com.listeny.listeny.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Si el retorno no está vacío significa que el usuario existe, si está vacío, significa que no existe
    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario=:username")
    public Usuario findByUsername(@Param("username") String username);
}
