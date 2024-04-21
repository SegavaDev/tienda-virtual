package com.segavaDev.tiendaVirtual.repositories.entities;

import java.time.LocalDate;

import com.segavaDev.tiendaVirtual.repositories.enums.Estados;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Personal extends Persona {

    @Enumerated(EnumType.STRING)
    private Estados estado;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private final LocalDate fechaRegistro = LocalDate.now();

    @ManyToOne
    @JoinColumn(
        name = "empresa_id"
    )
    private Empresa empresa;

    // Agg tienda o sucursal

}
