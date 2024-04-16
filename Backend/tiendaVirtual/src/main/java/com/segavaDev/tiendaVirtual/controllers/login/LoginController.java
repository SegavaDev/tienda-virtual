package com.segavaDev.tiendaVirtual.controllers.login;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "redirect:/login.html";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        try {
            return "redirect:/dashboard.html";

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            return "redirect:/error.html";
        }
    }
    
    
}
