package com.segavaDev.tiendaVirtual.repositories.model.dto.personal.principal;

import java.io.Serializable;

import com.segavaDev.tiendaVirtual.repositories.entities.Rol;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public abstract class PersonaDTO implements Serializable {

    private long cedula;

    private String p_nombre;

    private String s_nombre;

    private String p_apellido;
    
    private String s_apellido;

    private Rol rol;

    private String email;

    private String passWord;
    
}
