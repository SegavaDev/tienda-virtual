package com.segavaDev.tiendaVirtual.repositories.enums;

import java.util.Arrays;

public enum Roles {
    ADMIN,
    USER,
    CAJA;

    public static boolean exists(String value) {
        return Arrays.stream(Roles.values())
                .anyMatch(role -> role.name().equalsIgnoreCase(value));
    }

}