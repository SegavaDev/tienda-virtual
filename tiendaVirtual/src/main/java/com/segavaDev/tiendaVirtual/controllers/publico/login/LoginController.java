package com.segavaDev.tiendaVirtual.controllers.publico.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.segavaDev.tiendaVirtual.config.security.ManagerCookies;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "logout", required = false) String logout, HttpServletResponse response) {
        try {
            if(logout != null) {
                System.out.println("HOla");
                ManagerCookies.eliminarCookie(response, "auth_token");
                return "redirect:";
            }
            else {
                return "redirect:/login.html";
            }

        } catch (Exception e) {
            e.getMessage();
            return "redirect:/";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "redirect:/dashboard.html";
    }
    
}
