package com.listeny.listeny.repository;

import com.listeny.listeny.models.Lista;
import com.listeny.listeny.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long> {

    @Query("SELECT l FROM Lista l ORDER BY l.reproducciones DESC")
    public List<Lista> listasMasReproducidas();

//    @Query("SELECT l FROM Lista l WHERE l.listasCategoria.id = :idCategoria")
//    public List<Lista> listasPorCategoria(Long idCategoria);
    public List<Lista> findListasByPropietarioLista(Usuario usuario);
    public List<Lista> findListasByListasCategoria_Id(Long idCategoria);
    public List<Lista> findListasByNombreContaining(String nombre);
//    @Query("SELECT l FROM Lista l WHERE l.nombre LIKE :nombre")
//    public List<Lista> findByNombreContaining(@Param("nombre") String nombre);


}
