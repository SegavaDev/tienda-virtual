package com.segavaDev.tiendaVirtual.repositories.entities;

import java.io.Serializable;

import com.segavaDev.tiendaVirtual.repositories.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRol;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Roles nombre;

    @Setter(AccessLevel.NONE)
    private String permisos;
    
    private String descripcion;

    public Rol(Roles nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.setPermisos();
    }

    public void setPermisos() {
        this.permisos = this.nombre.getPermiso();
    }
    
}
