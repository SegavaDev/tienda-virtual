package com.segavaDev.tiendaVirtual.repositories.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@DiscriminatorValue("Administrador")
public class Administrador extends Personal {

    private String tienda;
    
}
