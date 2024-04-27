package com.segavaDev.tiendaVirtual.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.segavaDev.tiendaVirtual.repositories.entities.Cliente;
import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.model.dto.cliente.ClienteDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.personal.creacion.PersonalDTOcreacion;
import com.segavaDev.tiendaVirtual.repositories.model.dto.rol.RolDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;

@Component
public class ClienteConvert {

    @Autowired
    private ModelMapper model;

    public ClienteDTO dtoCrearToDTO(UsuarioDTOcreacion usuarioDTOcreacion, RolDTO rol) {
        ClienteDTO clienteDTO = model.map(usuarioDTOcreacion, ClienteDTO.class);

        clienteDTO.setRol(rol);

        return clienteDTO;
    }

    public ClienteDTO dtoCrearToDTO(PersonalDTOcreacion personalDTOcreacion, RolDTO rol) {
        ClienteDTO clienteDTO = model.map(personalDTOcreacion, ClienteDTO.class);

        clienteDTO.setRol(rol);

        return clienteDTO;
    }

    public Cliente dtoCrearToEntity(UsuarioDTOcreacion usuarioDTOcreacion, Rol rol) {
        Cliente cliente = model.map(usuarioDTOcreacion, Cliente.class);

        cliente.setRol(rol);

        return cliente;
    }

    public Cliente dtoToEntity(ClienteDTO clienteDTO) {
        return model.map(clienteDTO, Cliente.class);
    }
    
}
