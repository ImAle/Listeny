package com.listeny.listeny.repository;

import com.listeny.listeny.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Si el retorno no está vacío significa que el usuario existe, si está vacío, significa que no existe
//    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario=:username")
//    public Optional<Usuario> findByUsername(@Param("username") String username);
    public Optional<Usuario> findUsuarioByNombreUsuario(String username);
    public Optional<Usuario> findUsuarioByEmail(String email);

    public List<Usuario> findUsuarioByNombreUsuarioContainingIgnoreCase(String username);

//    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario LIKE :username")
//    public List<Usuario> findByUsernameConteining(@Param("username") String username);

//    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
//    public Optional<Usuario> findUserByEmail(@Param("email") String email);

}
