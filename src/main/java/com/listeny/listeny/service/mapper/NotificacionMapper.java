package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.NotificacionDto;
import com.listeny.listeny.models.Notificacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class NotificacionMapper extends AbstractServiceMapper<Notificacion, NotificacionDto> {

    ModelMapper modelMapper = new ModelMapper();

    // Convertir entidad a DTO
    @Override
    public NotificacionDto toDto(Notificacion entidad){
        final NotificacionDto dto = new NotificacionDto();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Notificacion toEntity(NotificacionDto dto){
        final Notificacion entidad = new Notificacion();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
