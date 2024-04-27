package com.segavaDev.tiendaVirtual.services.empresa;

import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.reportes.ReportEmpresaValidRegis;

public interface EmpresaService {

    void crearEmpresa(EmpresaDTO empresaDTO);

    EmpresaDTO buscarNit(String nit);

    ReportEmpresaValidRegis validarNit(EmpresaDTO empresaDTO);
    
}
