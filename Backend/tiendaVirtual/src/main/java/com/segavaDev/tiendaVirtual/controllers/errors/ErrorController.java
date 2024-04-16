package com.segavaDev.tiendaVirtual.controllers.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/acceso-denegado")
    public String error() {

        return "redirect: /error.html";

    }
    
}
