package com.segavaDev.tiendaVirtual.controllers.authenticate;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;

import com.segavaDev.tiendaVirtual.config.security.ManagerCookies;
import com.segavaDev.tiendaVirtual.repositories.model.jwt_models.JWTRequest;
import com.segavaDev.tiendaVirtual.services.jwt.JWTService;
import com.segavaDev.tiendaVirtual.services.jwt.JWTUserDetailService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTUserDetailService jwtUserDetailService;
    private final JWTService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> postToken(@RequestBody JWTRequest request, HttpServletResponse response) {
        if (request == null || request.getUsername() == null || request.getUsername().isEmpty()) {
            System.out.println("Error: El objeto JWTRequest es nulo o vacío.");
            return ResponseEntity.badRequest().body("Solicitud inválida");
        }
        else {
            this.authenticate(request);
            final var userDetails = this.jwtUserDetailService.loadUserByUsername(request.getUsername());

            final var token = this.jwtService.generateToken(userDetails);

            // Crear cookie
            ManagerCookies.crearCookieJWT(response, "auth_token", token, (int) JWTService.JWT_TOKEN_VALIDITY);

            // Redirigir a la página de inicio
            return ResponseEntity.ok("Login successful");
        }
    }

    private void authenticate(JWTRequest request) {
        try {
            this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword())
            );
        } catch (BadCredentialsException bc) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
        } catch (DisabledException ds) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuario deshabilitado");
        } catch (NotFoundException nf) {
            System.out.println(nf.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró");
        }
    }
}
