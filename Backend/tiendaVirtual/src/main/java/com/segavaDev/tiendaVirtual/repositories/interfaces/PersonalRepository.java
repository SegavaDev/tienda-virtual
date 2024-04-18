package com.segavaDev.tiendaVirtual.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.segavaDev.tiendaVirtual.repositories.entities.Personal;
import java.util.Optional;


public interface PersonalRepository extends JpaRepository<Personal, Long> {

    Optional<Personal> findByCedula(long cedula);

    Optional<Personal> findByEmail(String email);
    
}
