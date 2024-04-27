package com.segavaDev.tiendaVirtual.repositories.model.dto.personal.principal;

import com.segavaDev.tiendaVirtual.repositories.enums.Estados;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.persona.PersonaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonalDTO extends PersonaDTO {

    private Estados estado;

    private EmpresaDTO empresa;

}
