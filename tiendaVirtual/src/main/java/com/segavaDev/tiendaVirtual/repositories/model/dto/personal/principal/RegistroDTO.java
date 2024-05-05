package com.segavaDev.tiendaVirtual.repositories.model.dto.personal.principal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RegistroDTO {

    @JsonProperty("user")
    private UsuarioDTOcreacion usuarioDTOcreacion;

    @JsonProperty("empresa")
    private EmpresaDTO empresaDTO;
    
}
