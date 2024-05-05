package com.segavaDev.tiendaVirtual.services.rol.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.enums.Roles;
import com.segavaDev.tiendaVirtual.repositories.interfaces.RolRepository;
import com.segavaDev.tiendaVirtual.services.rol.RolServicePriv;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RolServiceImpPriv implements RolServicePriv {

    // Repository
    private final RolRepository rolRepository;
    
    @Transactional(readOnly = true)
    @Override
    public Rol buscarNombre(final Roles rol) {
        return rolRepository.findByNombre(rol).orElse(null);
    }
    
}
