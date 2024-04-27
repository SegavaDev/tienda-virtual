package com.segavaDev.tiendaVirtual.services.cliente;

import java.util.List;

import com.segavaDev.tiendaVirtual.repositories.entities.Cliente;

public interface ClienteServicePriv {
    
    Cliente buscarCedula(Long cedula);

    Cliente buscarNombre(String nombre);

    Cliente buscarEmail(String email);

    List<Cliente> clientesTodos();

}
