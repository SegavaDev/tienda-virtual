package com.segavaDev.tiendaVirtual.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.segavaDev.tiendaVirtual.repositories.entities.Empresa;
import com.segavaDev.tiendaVirtual.repositories.entities.Personal;
import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.personal.creacion.PersonalDTOcreacion;
import com.segavaDev.tiendaVirtual.repositories.model.dto.personal.principal.PersonalDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.rol.RolDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;

@Component
public class PersonalConvert {
    
    @Autowired
    private ModelMapper model;

    public PersonalDTO dtoCrearToDto(PersonalDTOcreacion personalDTOcreacion, RolDTO rol, EmpresaDTO empresa) {
        PersonalDTO personalDTO = model.map(rol, PersonalDTO.class);
        personalDTO.setRol(rol);
        personalDTO.setEmpresa(empresa);

        return personalDTO;
    }

    public Personal dtoCrearToEntity(PersonalDTOcreacion personalDTOcreacion, Rol rol, Empresa empresa) {
        Personal personal = model.map(personalDTOcreacion, Personal.class);
        personal.setRol(rol);
        personal.setEmpresa(empresa);

        return personal;
    }

    public Personal dtoCrearToEntity(UsuarioDTOcreacion usuarioDTOcreacion, Rol rol, Empresa empresa) {
        Personal personal = model.map(usuarioDTOcreacion, Personal.class);
        personal.setRol(rol);
        personal.setEmpresa(empresa);

        return personal;
    }

    public Personal dtoToEntity(PersonalDTO personalDTO) {
        return model.map(personalDTO, Personal.class);
    }

}
