package com.segavaDev.tiendaVirtual.controllers.errors;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class ErrorController {

    @GetMapping("/error")
    public ResponseEntity<String> error() {
        String response = "Ha ocurrido un error";
        System.out.println(response);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> AccesoDenegado(AccessDeniedException e) {
        String response = "No cuenta con los permisos de acceso, por favor loguese.";
        System.out.println(response);

        return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
    }
    
}
