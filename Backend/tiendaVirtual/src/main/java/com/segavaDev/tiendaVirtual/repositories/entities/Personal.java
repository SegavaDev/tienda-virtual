package com.segavaDev.tiendaVirtual.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Personal extends Persona {

    private long codEmpleado;

    public void setCodEmpleado() {
        this.codEmpleado = this.hashCode();
    }
    
}
