package com.listeny.listeny.service;

import com.listeny.listeny.Dto.RolDto;
import com.listeny.listeny.Dto.UsuariosDto;
import com.listeny.listeny.models.*;
import com.listeny.listeny.repository.RolRepository;
import com.listeny.listeny.repository.UsuarioRepository;
import com.listeny.listeny.service.mapper.RolMapper;
import com.listeny.listeny.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
