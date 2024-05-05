package com.segavaDev.tiendaVirtual.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segavaDev.tiendaVirtual.repositories.entities.Empresa;
import java.util.Optional;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findByNit(String nit);

    Optional<Empresa> findByNombre(String nombre);

    Optional<Empresa> findByDireccion(String direccion);
    
}
