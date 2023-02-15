package com.listeny.listeny.service;

import com.listeny.listeny.Dto.RolDto;
import com.listeny.listeny.models.Rol;
import com.listeny.listeny.repository.RolRepository;
import com.listeny.listeny.service.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RolService extends AbstractBusinessService<Rol, Long, RolDto, RolRepository, RolMapper>{

    @Autowired
    CancionService cancionService;
    @Autowired
    ListaService listaService;
    @Autowired
    AlbumService albumService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public RolService(RolRepository repo, RolMapper mapper) {
        super(repo, mapper);
    }


}
