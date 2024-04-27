package com.segavaDev.tiendaVirtual.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.model.dto.rol.RolDTO;

@Component
public class RolConvert {

    @Autowired
    private ModelMapper model;

    public Rol dtoToEntity(RolDTO rolDTO) {
        return model.map(rolDTO, Rol.class);
    }

    public RolDTO entityToDto(Rol rol) {
        return model.map(rol, RolDTO.class);
    }
    
}
