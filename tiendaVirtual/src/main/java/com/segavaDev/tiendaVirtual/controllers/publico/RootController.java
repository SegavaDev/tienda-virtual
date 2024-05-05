package com.segavaDev.tiendaVirtual.controllers.publico;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class RootController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index.html";
    }
    
    
}
