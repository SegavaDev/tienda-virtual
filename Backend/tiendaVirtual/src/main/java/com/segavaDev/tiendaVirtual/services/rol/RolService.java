package com.segavaDev.tiendaVirtual.services.rol;

import com.segavaDev.tiendaVirtual.repositories.enums.Roles;
import com.segavaDev.tiendaVirtual.repositories.model.dto.rol.RolDTO;

public interface RolService {
    
    RolDTO buscarNombre(Roles rol);

}
