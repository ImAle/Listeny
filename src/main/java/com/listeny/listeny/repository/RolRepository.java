package com.listeny.listeny.repository;

import com.listeny.listeny.models.Rol;
import com.listeny.listeny.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    // Si el retorno no está vacío significa que el usuario existe, si está vacío, significa que no existe


}
