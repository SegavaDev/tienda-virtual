package com.segavaDev.tiendaVirtual.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.segavaDev.tiendaVirtual.repositories.entities.Empresa;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;

@Component
public class EmpresaConvert {

    @Autowired
    private ModelMapper model;

    public Empresa dtoToEntity(EmpresaDTO empresaDTO) {
        return model.map(empresaDTO, Empresa.class);
    }

    public EmpresaDTO entityToDto(Empresa empresa) {
        return model.map(empresa, EmpresaDTO.class);
    }
    
}
