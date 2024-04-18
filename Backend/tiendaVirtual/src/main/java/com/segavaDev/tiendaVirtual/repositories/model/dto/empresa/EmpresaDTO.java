package com.segavaDev.tiendaVirtual.repositories.model.dto.empresa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmpresaDTO {

    private long nit;

    private long nombre;

    private String direccion;
    
}
