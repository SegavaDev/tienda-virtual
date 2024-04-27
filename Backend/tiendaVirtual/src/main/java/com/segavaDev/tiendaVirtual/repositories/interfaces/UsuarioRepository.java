package com.segavaDev.tiendaVirtual.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segavaDev.tiendaVirtual.repositories.entities.Persona;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findByCedula(long cedula);

    Optional<Persona> findByEmail(String email);
    
}
