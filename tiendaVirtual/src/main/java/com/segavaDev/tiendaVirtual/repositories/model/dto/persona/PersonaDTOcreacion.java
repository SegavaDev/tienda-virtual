package com.segavaDev.tiendaVirtual.repositories.model.dto.persona;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class PersonaDTOcreacion implements Serializable {

    private long cedula;

    private String p_nombre;

    private String s_nombre;

    private String p_apellido;
    
    private String s_apellido;

    private String rol;

    private String email;

    private String passWord;

    private String telefono;

    private char sexo;
    
}
