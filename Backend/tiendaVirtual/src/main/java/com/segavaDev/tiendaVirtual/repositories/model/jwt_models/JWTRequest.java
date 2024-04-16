package com.segavaDev.tiendaVirtual.repositories.model.jwt_models;

import lombok.Data;

@Data
public class JWTRequest {

	private String username;
	private String password;
    
}