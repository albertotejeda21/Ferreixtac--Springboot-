package com.example.ferre_ixtacZ.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.ferre_ixtacZ.servicios.usuarioService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired private JwtUtil jwtUtil;
    @Autowired private usuarioService userService;

@Override
protected boolean shouldNotFilter(HttpServletRequest request) {
    return request.getRequestURI().equals("/api/auth/login");
}



    @Override
    
    protected void doFilterInternal(HttpServletRequest request, 
                        HttpServletResponse response, 
                                    FilterChain chain)
            throws ServletException, IOException {

    System.out.println("LALALA URI: " + request.getRequestURI());
    System.out.println("Header: " + request.getHeader("Authorization"));

        String header = request.getHeader("Authorization");
        String token = null;
        String usuario = null;  

        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);
            usuario = jwtUtil.extraerUsuario(token);
        }

        if (usuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userService.loadUserByUsername(usuario);
            if (jwtUtil.validarToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        chain.doFilter(request, response);
    }
}
