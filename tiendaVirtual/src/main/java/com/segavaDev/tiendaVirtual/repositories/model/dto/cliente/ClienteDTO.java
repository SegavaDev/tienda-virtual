package com.segavaDev.tiendaVirtual.repositories.model.dto.cliente;

import java.time.LocalDate;

import com.segavaDev.tiendaVirtual.repositories.enums.Estados;
import com.segavaDev.tiendaVirtual.repositories.model.dto.persona.PersonaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClienteDTO extends PersonaDTO {

    private Estados estado;

    private final LocalDate fechaRegistro = LocalDate.now();

}
