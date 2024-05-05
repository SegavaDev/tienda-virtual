package com.segavaDev.tiendaVirtual.repositories.model.dto.usuario;

import com.segavaDev.tiendaVirtual.repositories.model.dto.persona.PersonaDTOcreacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UsuarioDTOcreacion extends PersonaDTOcreacion {

    private String empresa;

}
