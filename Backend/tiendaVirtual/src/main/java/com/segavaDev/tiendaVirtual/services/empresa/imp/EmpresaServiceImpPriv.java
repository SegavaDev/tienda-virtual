package com.segavaDev.tiendaVirtual.services.empresa.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.segavaDev.tiendaVirtual.repositories.entities.Empresa;
import com.segavaDev.tiendaVirtual.repositories.interfaces.EmpresaRepository;
import com.segavaDev.tiendaVirtual.services.empresa.EmpresaServicePriv;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpresaServiceImpPriv implements EmpresaServicePriv {

    // Repository
    private final EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    @Override
    public Empresa buscarNit(String nit) {
        return empresaRepository.findByNit(nit).orElse(null);
    }
    
}
