package com.segavaDev.tiendaVirtual.repositories.enums;

import java.util.Arrays;

public enum Roles {
    GERENTE("Todos los permisos"),
    ADMINISTRADOR("Todos los permisos excepto modificar gerente"),
    CAJA("Crear y ver (ventas, facturas, clientes(usuarios)), ver inventario"),
    USUARIO("Ver productos en tienda virtual"); 

    private String permiso;

    private Roles(String permiso) {
        this.permiso = permiso;
    }

    public String getPermiso() {
        return this.permiso;
    }

    public static boolean exists(String rol) {
        return Arrays.stream(Roles.values())
                .anyMatch(role -> role.name().equalsIgnoreCase(rol));
    }

}