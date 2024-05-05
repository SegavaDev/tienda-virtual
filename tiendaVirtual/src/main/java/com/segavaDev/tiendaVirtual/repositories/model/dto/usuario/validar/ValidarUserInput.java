package com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.validar;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidarUserInput implements Serializable {

    private Long cedula;

    private String email;
    
}
