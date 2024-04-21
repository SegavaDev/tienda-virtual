package com.segavaDev.tiendaVirtual.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segavaDev.tiendaVirtual.repositories.entities.Rol;
import com.segavaDev.tiendaVirtual.repositories.enums.Roles;
import java.util.List;


public interface RolRepository extends JpaRepository<Rol, Long> {

    List<Rol> findByNombre(Roles nombre);
    
}
