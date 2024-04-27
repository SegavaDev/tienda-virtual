package com.segavaDev.tiendaVirtual.services.rol;

import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.enums.Roles;

public interface RolServicePriv {

    Rol buscarNombre(Roles rol);
    
}
