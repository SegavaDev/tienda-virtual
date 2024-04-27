package com.segavaDev.tiendaVirtual.util.validaciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estado {

    private String titulo;

    private boolean valido;

    private String descripcion;
    
}
