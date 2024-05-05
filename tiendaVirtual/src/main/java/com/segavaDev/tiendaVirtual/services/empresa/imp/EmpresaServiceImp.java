package com.segavaDev.tiendaVirtual.services.empresa.imp;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.segavaDev.tiendaVirtual.components.converters.EmpresaConvert;
import com.segavaDev.tiendaVirtual.repositories.entities.Empresa;
import com.segavaDev.tiendaVirtual.repositories.interfaces.EmpresaRepository;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.reportes.ReportEmpresaValidRegis;
import com.segavaDev.tiendaVirtual.services.empresa.EmpresaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpresaServiceImp implements EmpresaService {

    // repository
    private final EmpresaRepository empresaRepository;

    // Convert
    private EmpresaConvert empresaConvert;

    @Transactional
    @Override
    public void crearEmpresa(final EmpresaDTO empresaDTO) {
        empresaRepository.save(empresaConvert.dtoToEntity(empresaDTO));
    }

    @Transactional(readOnly = true)
    @Override
    public EmpresaDTO buscarNit(String nit) {
        return empresaConvert.entityToDto(empresaRepository.findByNit(nit).orElse(null));
    }

    @Transactional(readOnly = true)
    @Override
    public ReportEmpresaValidRegis validarNit(final EmpresaDTO empresaDTO) {
        Optional<Empresa> empresa = empresaRepository.findByNit(empresaDTO.getNit());

        ReportEmpresaValidRegis validRegis = new ReportEmpresaValidRegis();

        validRegis.setNit(
            empresa.isPresent() ? true : false
        );

        validRegis.setNombre(
            empresa.get().getNombre()
            .equalsIgnoreCase(empresaDTO.getNombre())
        );

        validRegis.setDireccion(
            empresa.get().getDireccion()
            .equalsIgnoreCase(empresaDTO.getDireccion())
        );

        return validRegis;

    }
    
}
