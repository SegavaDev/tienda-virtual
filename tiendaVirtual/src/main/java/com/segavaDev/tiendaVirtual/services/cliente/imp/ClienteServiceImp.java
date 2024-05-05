package com.segavaDev.tiendaVirtual.services.cliente.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.segavaDev.tiendaVirtual.components.converters.ClienteConvert;
import com.segavaDev.tiendaVirtual.repositories.entities.Cliente;
import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.enums.Estados;
import com.segavaDev.tiendaVirtual.repositories.enums.Roles;
import com.segavaDev.tiendaVirtual.repositories.interfaces.ClienteRepository;
import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.UsuarioDTOcreacion;
import com.segavaDev.tiendaVirtual.services.cliente.ClienteService;
import com.segavaDev.tiendaVirtual.services.rol.RolServicePriv;
import com.segavaDev.tiendaVirtual.util.exceptions.ErrorRolValue;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImp implements ClienteService {

    // Repository
    private final ClienteRepository clienteRepository;

    // Privados
    private final RolServicePriv rolServicePriv;

    // Converters
    private final ClienteConvert clienteConvert;
    

    @Transactional
    @Override
    public void registrarUsuario(final UsuarioDTOcreacion usuarioDTOcreacion) throws ErrorRolValue {

        if(Roles.exists(usuarioDTOcreacion.getRol())) {

            Rol rol = rolServicePriv.buscarNombre(Roles.valueOf(usuarioDTOcreacion.getRol()));
            Cliente cliente = clienteConvert.dtoCrearToEntity(usuarioDTOcreacion, rol); 
            cliente.setEstado(Estados.ACTIVO);
            
            clienteRepository.save(cliente);
        }
        else {
            throw new ErrorRolValue("El rol " + usuarioDTOcreacion.getRol() + " no existe");
        }
        
    }
    
}
