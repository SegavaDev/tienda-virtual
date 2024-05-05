package com.segavaDev.tiendaVirtual.repositories.enums;

import java.util.Arrays;

public enum Estados {
    ACTIVO,
    SUSPENDIDO,
    VACACIONES,
    DESHABILITADO,
    INACTIVO,
    RETIRADO;

    public boolean exists(String estado) {
        return Arrays.stream(Estados.values())
                .anyMatch(estad -> estad.name().equalsIgnoreCase(estado));
    }

}
