package com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.reportes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportEmpresaValidRegis {

    private boolean nit;

    private boolean nombre;

    private boolean direccion;
    
}
