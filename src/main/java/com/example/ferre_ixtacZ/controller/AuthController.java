package com.example.ferre_ixtacZ.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
import org.springframework.web.bind.annotation.RestController;

import com.example.ferre_ixtacZ.DTOs.articulosDTO;
import com.example.ferre_ixtacZ.DTOs.usuariosDTO;
import com.example.ferre_ixtacZ.jwt.JwtUtil;

@RestController
@RequestMapping("/api/auth")


public class AuthController {



    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody usuariosDTO dto) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getUsuario(), dto.getPassword())
        );
        String token = jwtUtil.generarToken(dto.getUsuario());
        return ResponseEntity.ok(token);
    }
}