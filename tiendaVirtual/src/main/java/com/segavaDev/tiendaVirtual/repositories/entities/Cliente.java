package com.segavaDev.tiendaVirtual.repositories.entities;

import java.time.LocalDate;

import com.segavaDev.tiendaVirtual.repositories.enums.Estados;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
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
@Table(name = "Clientes")
public class Cliente extends Persona {

    @Enumerated(EnumType.STRING)
    private Estados estado;

    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private final LocalDate fechaRegistro = LocalDate.now();

}
