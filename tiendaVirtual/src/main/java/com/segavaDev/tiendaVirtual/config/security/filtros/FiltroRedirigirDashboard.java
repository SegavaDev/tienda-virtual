package com.segavaDev.tiendaVirtual.config.security.filtros;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FiltroRedirigirDashboard extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()
        && request.getRequestURI().equals("/dashboard")) {
            System.out.println("URI: " + request.getRequestURI());
            System.out.println("Login: " + authentication.getPrincipal().toString());
            response.sendRedirect("/dashboard.html");
            return;
        }

        filterChain.doFilter(request, response);

    }
    
}
