package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.ReproduccionDto;
import com.listeny.listeny.models.Reproduccion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReproduccionMapper extends AbstractServiceMapper<Reproduccion,ReproduccionDto> {

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public ReproduccionDto toDto(Reproduccion entidad){
        final ReproduccionDto dto = new ReproduccionDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Reproduccion toEntity(ReproduccionDto dto){
        final Reproduccion entidad = new Reproduccion();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
