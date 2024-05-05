package com.segavaDev.tiendaVirtual.services.personal;

import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;

public interface PersonalService {
    
    void registrarPersona(UsuarioDTOcreacion personalDTOcreacion);

}
