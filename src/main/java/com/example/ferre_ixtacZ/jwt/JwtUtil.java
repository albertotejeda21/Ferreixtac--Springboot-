package com.example.ferre_ixtacZ.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import java.util.Date; 
//import java.sql.Date;
import com.example.ferre_ixtacZ.controller.AuthController;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import  com.example.ferre_ixtacZ.jwt.JwtFilter;

@Component
public class JwtUtil {

    private static final SecretKey SECRET = Jwts.SIG.HS256.key().build();
    private static final long EXPIRATION = 86400000; // 24 horas

    public String generarToken(String usuario) {
        return Jwts.builder()
            .subject(usuario)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(SECRET)
            .compact();
    }

    public String extraerUsuario(String token) {
        return Jwts.parser()
            .verifyWith(SECRET)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    public boolean validarToken(String token, UserDetails userDetails) {
        return extraerUsuario(token).equals(userDetails.getUsername());
    }
}