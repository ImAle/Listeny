package com.listeny.listeny.service;

import com.listeny.listeny.service.mapper.AbstractServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public abstract class AbstractBusinessService<E, ID, DTO,  REPO extends JpaRepository<E,ID> ,
        MAPPER extends AbstractServiceMapper<E,DTO>> {
    private final REPO repo;
    private final MAPPER mapper;


    protected AbstractBusinessService(REPO repo, MAPPER mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    //Lista de todos los DTOs buscarTodos devolverá lista y páginas
    public List<DTO> buscarTodos(){
        return  this.mapper.toDto(this.repo.findAll());
    }

    public Set<DTO> buscarTodosSet(){
        return new HashSet<DTO>(this.mapper.toDto(this.repo.findAll()));
    }

    public Page<DTO> buscarTodos(Pageable pageable){
        return  repo.findAll(pageable).map(this.mapper::toDto);
    }

    //Buscar por id
    public Optional<DTO> encuentraPorId(ID id){
        return this.repo.findById(id).map(this.mapper::toDto);
    }

    public Optional<E> encuentraPorIdEntity (ID id){
        return this.repo.findById(id);
    }

    //Guardar
    public DTO guardar(DTO dto) throws Exception {
        //Traduzco del dto con datos de entrada a la entidad
        final E entidad = mapper.toEntity(dto);
        //Guardo en la base de datos
        E entidadGuardada =  repo.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return mapper.toDto(entidadGuardada);
    }
    public void  guardar(List<DTO> dtos) throws Exception {
        Iterator<DTO> it = dtos.iterator();

        // mientras al iterador tenga siguiente
        while(it.hasNext()){
            //Obtenemos la contraseña de la entidad
            //Datos del usuario
            E e = mapper.toEntity(it.next());
            repo.save(e);
        }
    }

    //eliminar un registro
    public void eliminarPorId(ID id){
        this.repo.deleteById(id);
    }
    //Obtener el mapper
    public MAPPER getMapper(){return  mapper;}
    //Obtener el repo
    public REPO getRepo(){return  repo;}
}
