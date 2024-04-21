package com.segavaDev.tiendaVirtual.controllers.registrar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segavaDev.tiendaVirtual.repositories.model.dto.personal.principal.RegistroDTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RegistrarResController {

    @PostMapping("/registrarse")
    public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody RegistroDTO registroDTO, BindingResult result) {
        System.out.println(registroDTO.toString());

        Map<String, Object> response = new HashMap<>();
        
        response.put("Prueba", registroDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
}
