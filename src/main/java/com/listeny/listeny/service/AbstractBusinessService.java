package com.listeny.listeny.service;

import com.listeny.listeny.models.Cancion;
import com.listeny.listeny.service.mapper.AbstractServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    public Page<E> buscarTodosPagEnt(Pageable pageable){

        return  repo.findAll(pageable);

    }

    //Buscar por id
    public Optional<DTO> encuentraPorId(ID id){
        return this.repo.findById(id).map(this.mapper::toDto);
    }

    public Optional<E> encuentraPorIdEntity (ID id){
        return this.repo.findById(id);
    }

    //Guardar
    public DTO save(DTO dto) throws Exception {
        //Traduzco del dto con datos de entrada a la entidad
        final E entidad = mapper.toEntity(dto);
        //Guardo en la base de datos
        E entidadGuardada =  repo.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return mapper.toDto(entidadGuardada);
    }
    public void  save(List<DTO> dtos) throws Exception {
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

    //Obtener un set de objetos seleccionados al azar

    public Set<Long> generadorId (int cantidad){
        Long rango = repo.count();
        Set<Long> setId = new HashSet<>();
        Random rnd = new Random();
        while (setId.size() < cantidad){
            Long num = (long)rnd.nextInt(rango.intValue());
            if (num != 0 && !setId.contains(num)){
                setId.add(num);
            }
        }
        return setId;
    }

    public String subirImagen(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        String URL = "/static/imagenes/";

        assert contentType != null;
        if (!contentType.equals("image/jpeg") && !contentType.equals("image/png")) {
            throw new IllegalArgumentException("El tipo de archivo no es permitido. Solo se permiten imágenes en formato JPEG o PNG.");
        }

        String filePath = URL + fileName;
        File destinationFile = new File(filePath);
        file.transferTo(destinationFile);
        return filePath;
    }

    public void borrarImagen(String nombreImagen) {
        String URL = "/static/imagenes/";
        String filePath = URL + nombreImagen;
        File archivoImagen = new File(filePath);
        if (archivoImagen.exists()) {
            archivoImagen.delete();
        }
    }

    public void cambiarImagen(MultipartFile file, String nombreImagenAnterior) throws IOException {
        borrarImagen(nombreImagenAnterior);
        subirImagen(file);
    }


    //Obtener el mapper
    public MAPPER getMapper(){return  mapper;}
    //Obtener el repo
    public REPO getRepo(){return  repo;}

}
