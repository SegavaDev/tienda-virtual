package com.segavaDev.tiendaVirtual.repositories.model.dto.rol;

import java.io.Serializable;

import com.segavaDev.tiendaVirtual.repositories.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RolDTO implements Serializable {
    
    private Roles nombre;

    private String permisos;
    
    private String descripcion;
    
}
