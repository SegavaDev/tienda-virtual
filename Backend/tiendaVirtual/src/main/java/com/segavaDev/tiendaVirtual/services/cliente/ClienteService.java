package com.segavaDev.tiendaVirtual.services.cliente;

import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;
import com.segavaDev.tiendaVirtual.util.exceptions.ErrorRolValue;

public interface ClienteService {
    
    void registrarUsuario(UsuarioDTOcreacion usuarioDTOcreacion) throws ErrorRolValue;

}
