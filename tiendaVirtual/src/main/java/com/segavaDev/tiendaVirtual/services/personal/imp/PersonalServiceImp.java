package com.segavaDev.tiendaVirtual.services.personal.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.segavaDev.tiendaVirtual.components.converters.PersonalConvert;
import com.segavaDev.tiendaVirtual.repositories.entities.Empresa;
import com.segavaDev.tiendaVirtual.repositories.entities.Personal;
import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.enums.Estados;
import com.segavaDev.tiendaVirtual.repositories.enums.Roles;
import com.segavaDev.tiendaVirtual.repositories.interfaces.PersonalRepository;
import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;
import com.segavaDev.tiendaVirtual.services.empresa.EmpresaServicePriv;
import com.segavaDev.tiendaVirtual.services.personal.PersonalService;
import com.segavaDev.tiendaVirtual.services.rol.RolServicePriv;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonalServiceImp implements PersonalService {

    // Repository
    private final PersonalRepository personalRepository;

    // Privado
    private final RolServicePriv rolServicePriv;
    private final EmpresaServicePriv empresaServicePriv;

    // Converts
    private final PersonalConvert personalConvert;

    @Transactional
    @Override
    public void registrarPersona(UsuarioDTOcreacion usuarioDTOcreacion) {
        if(Roles.exists(usuarioDTOcreacion.getRol())) {
            Rol rol = rolServicePriv.buscarNombre(Roles.valueOf(usuarioDTOcreacion.getRol()));
            Empresa empresa = empresaServicePriv.buscarNit(usuarioDTOcreacion.getEmpresa());

            Personal personal = personalConvert.dtoCrearToEntity(usuarioDTOcreacion, rol, empresa);
            personal.setEstado(Estados.ACTIVO);

            personalRepository.save(personal);
        }
    }
    
}
