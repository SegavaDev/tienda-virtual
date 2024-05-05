package com.segavaDev.tiendaVirtual.services.rol.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.segavaDev.tiendaVirtual.components.converters.RolConvert;
import com.segavaDev.tiendaVirtual.repositories.enums.Roles;
import com.segavaDev.tiendaVirtual.repositories.interfaces.RolRepository;
import com.segavaDev.tiendaVirtual.repositories.model.dto.rol.RolDTO;
import com.segavaDev.tiendaVirtual.services.rol.RolService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RolServiceImp implements RolService {

    // Repository
    private final RolRepository rolRepository;

    // Convert
    private final RolConvert rolConvert;

    @Transactional(readOnly = true)
    @Override
    public RolDTO buscarNombre(Roles rol) {
        return rolConvert.entityToDto(rolRepository.findByNombre(rol).orElse(null));
    }
    
}
