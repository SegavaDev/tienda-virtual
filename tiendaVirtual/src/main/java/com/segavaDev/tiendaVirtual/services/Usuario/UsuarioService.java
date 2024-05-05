package com.segavaDev.tiendaVirtual.services.Usuario;

import com.segavaDev.tiendaVirtual.repositories.model.dto.empresa.EmpresaDTO;
import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;
import com.segavaDev.tiendaVirtual.util.exceptions.ErrorRolValue;

public interface UsuarioService {

    void registrarUsuario(UsuarioDTOcreacion usuarioDTOcreacion) throws ErrorRolValue;

    void registrarGerencia(UsuarioDTOcreacion usuarioDTOcreacion, EmpresaDTO empresaDTO);

    boolean validarCedula(Long cedula);

    boolean validarEmail(String email);
    
}
