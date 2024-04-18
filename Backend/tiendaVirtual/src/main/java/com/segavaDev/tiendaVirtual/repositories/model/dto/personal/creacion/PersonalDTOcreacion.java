package com.segavaDev.tiendaVirtual.repositories.model.dto.personal.creacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonalDTOcreacion extends PersonaDTOcreacion {

    private long empresa;

}
