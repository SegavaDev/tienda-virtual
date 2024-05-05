package com.segavaDev.tiendaVirtual.repositories.model.jwt_models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTRequest implements Serializable {

	private String username;
	private String password;
    
}