package com.segavaDev.tiendaVirtual.controllers.registrar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistrarController {

    @GetMapping("/registrar")
    public String registrar() {
        return "redirect:/registrar.html";
    }
    
    
}
