package com.segavaDev.tiendaVirtual.repositories.enums;

import java.util.Arrays;

public enum Roles {
    GERENTE("Todos los permisos"),
    ADMINISTRADOR("Todos los permisos excepto modificar gerente"),
    USUARIO("Ver productos"),
    CAJA("Crear, eliminar, modificar y ver (Productos, ventas)");

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