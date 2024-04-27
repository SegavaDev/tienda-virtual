package com.segavaDev.tiendaVirtual.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segavaDev.tiendaVirtual.repositories.entities.Cliente;
import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Optional<Cliente> findByCedula(long cedula);

    Optional<Cliente> findByEmail(String email);
    
}
