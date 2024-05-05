package com.segavaDev.tiendaVirtual.services.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.segavaDev.tiendaVirtual.config.firmaSecreta.FirmaSecreta;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    public static final long JWT_TOKEN_VALIDITY = 1 * 60 * 60;
    public static final long REFRESH_TOKEN_VALIDITY = 1 * 60 * 60;
    public static final String JWT_SECRET = FirmaSecreta.getFirma();

    private Claims getAllClaimsFromToken(String token) {
        final Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final var claims = this.getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpirationDateFromToken(String token) {
        return this.getClaimsFromToken(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        final var expirationDate = this.getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }

    public String getUsernameFromToken(String token) {
        return this.getClaimsFromToken(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails) {
        final Map<String, Object> claims = Collections.singletonMap("ROLES", userDetails.getAuthorities().toString());
        return this.getToken(claims, userDetails.getUsername());
    }

    private String getToken(Map<String, Object> claims, String subject) {
        final var key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final var usernameFromUserDetails = userDetails.getUsername();
        final var usernameFromJWT = this.getUsernameFromToken(token);

        return (usernameFromUserDetails.equals(usernameFromJWT)) && !this.isTokenExpired(token);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        // Crear el mapa de claims (información que quieres incluir en el token)
        Map<String, Object> claims = Map.of(
            "username", userDetails.getUsername(),
            "type", "refresh"
        );

        // Generar la clave de firma
        Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        // Construir el token
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALIDITY))
                .signWith(key, SignatureAlgorithm.HS256) // Tipo de firma
                .compact();
    }

    // Método para validar si un refresh token es válido
    public boolean isRefreshTokenValid(String refreshToken, String username) {
        try {
            Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
            
            // Obtener el nombre de usuario del token
            String tokenUsername = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(refreshToken)
                .getBody()
                .getSubject(); // Aquí extraes el nombre de usuario del token

            // Comprobar que el nombre de usuario del token coincide con el esperado
            if (!tokenUsername.equals(username)) {
                return false; // Si no coinciden, no es válido
            }

            // Si no se lanza ninguna excepción, el token es válido
            return true;
        } catch (ExpiredJwtException e) {
            // El token está caducado
            System.err.println("El refresh token está caducado.");
            return false;
        } catch (SignatureException e) {
            // Firma incorrecta
            System.err.println("El refresh token tiene una firma inválida.");
            return false;
        } catch (Exception e) {
            // Cualquier otra excepción
            System.err.println("Error al validar el refresh token: " + e.getMessage());
            return false;
        }
    }
}
