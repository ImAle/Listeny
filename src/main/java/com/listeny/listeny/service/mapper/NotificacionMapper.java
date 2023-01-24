package com.listeny.listeny.service.mapper;

import com.listeny.listeny.Dto.NotificacionDto;
import com.listeny.listeny.models.Notificacion;
import org.modelmapper.ModelMapper;

public class NotificacionMapper extends AbstractServiceMapper<Notificacion, NotificacionDto> {

    // Convertir entidad a DTO
    @Override
    public NotificacionDto toDto(Notificacion entidad){
        final NotificacionDto dto = new NotificacionDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    // Convertir DTO a entidad
    @Override
    public Notificacion toEntity(NotificacionDto dto){
        final Notificacion entidad = new Notificacion();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);
        return entidad;
    }

}
