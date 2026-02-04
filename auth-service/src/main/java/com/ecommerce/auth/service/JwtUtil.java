package com.ecommerce.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "MinhaChaveSecretaSuperSegura"; // pode vir do application.properties
    private final long expiration = 3600000; // 1 hora em milissegundos

    // Gera token JWT
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Extrai informações do token
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    // Valida token
    public boolean validateToken(String token, String username) {
        String tokenUsername = getClaims(token).getSubject();
        Date expirationDate = getClaims(token).getExpiration();
        return (tokenUsername.equals(username) && expirationDate.after(new Date()));
    }
}
