package com.segavaDev.tiendaVirtual.services.Usuario.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.segavaDev.tiendaVirtual.repositories.interfaces.UsuarioRepository;
import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;
import com.segavaDev.tiendaVirtual.services.Usuario.UsuarioService;
import com.segavaDev.tiendaVirtual.services.cliente.ClienteService;
import com.segavaDev.tiendaVirtual.services.empresa.EmpresaService;
import com.segavaDev.tiendaVirtual.services.personal.PersonalService;
import com.segavaDev.tiendaVirtual.util.exceptions.ErrorRolValue;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

    // repository
    private final UsuarioRepository usuarioRepository;

    // Servicios
    private final ClienteService clienteService;
    private final PersonalService personalService;
    private final EmpresaService empresaService;
    
    @Transactional
    @Override
    public void registrarUsuario(UsuarioDTOcreacion usuarioDTOcreacion) throws ErrorRolValue {
        clienteService.registrarUsuario(usuarioDTOcreacion);
    }

    @Transactional
    @Override
    public void registrarGerencia(UsuarioDTOcreacion usuarioDTOcreacion, EmpresaDTO empresaDTO) {
        empresaService.crearEmpresa(empresaDTO);
        personalService.registrarPersona(usuarioDTOcreacion);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean validarCedula(Long cedula) {
        return usuarioRepository.findByCedula(cedula).isPresent();
    }

    @Transactional(readOnly = true)
    @Override
    public boolean validarEmail(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }

}
