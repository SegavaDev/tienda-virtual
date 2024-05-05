package com.segavaDev.tiendaVirtual.controllers.publico.registrar;
    
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segavaDev.tiendaVirtual.repositories.model.dto.usuario.validar.ValidarUserInput;
import com.segavaDev.tiendaVirtual.services.Usuario.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/public/validar")
public class ValidarDataRegistro {
    
    // Servicios
    private final UsuarioService usuarioService;

    @PostMapping("/cedula")
    public ResponseEntity<Map<String, Object>> validarCedula(@RequestBody ValidarUserInput vInput, BindingResult result) {
        
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
            .stream().map(
                error -> error.getField() + " " + error.getDefaultMessage()
            ).collect(Collectors.toList());

            response.put("Errores", errors);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if(vInput.getCedula() == null) {
            response.put("result", false);
        }
        else {
            try {
                boolean existe = usuarioService.validarCedula(vInput.getCedula());

                response.put("result", existe);

            } catch (Exception e) {
                System.out.println(e);
                response.put("Error", "Ha ocurrido un error inesperado");

                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/email")
    public ResponseEntity<Map<String, Object>> validarEmail(@RequestBody ValidarUserInput vInput, BindingResult result) {
        
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
            .stream().map(
                error -> error.getField() + " " + error.getDefaultMessage()
            ).collect(Collectors.toList());

            response.put("Errores", errors);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else if(vInput.getEmail() == null) {
            response.put("result", false);
        }
        else {
            try {
                boolean existe = usuarioService.validarEmail(vInput.getEmail());

                response.put("result", existe);

            } catch (Exception e) {
                System.out.println(e);
                response.put("Error", "Ha ocurrido un error inesperado");

                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
