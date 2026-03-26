package com.example.ferre_ixtacZ.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.ferre_ixtacZ.jwt.JwtFilter;
import com.example.ferre_ixtacZ.servicios.usuarioService;


@Configuration
@EnableWebSecurity


public class securityConfig {
@Autowired
private JwtFilter jwtFilter;
private final usuarioService userService;


 public securityConfig(usuarioService userService) {
    this.userService = userService;
}



 @Bean
    public PasswordEncoder codificaPass(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager autenticacion(AuthenticationConfiguration authConfig)
        throws Exception{
        return authConfig.getAuthenticationManager();
    }


@Bean
public UserDetailsService userDetailsService() {
    return userService; 
}
    

    @Bean
    public SecurityFilterChain securityChain(HttpSecurity http)
            throws Exception{
http.csrf(csrf -> csrf.disable())
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/auth/**").permitAll()
        .anyRequest().authenticated()
    )
    .sessionManagement(sess -> sess
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
    ) 

    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                /*
             http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/**").permitAll().
                    requestMatchers("/api/articulo/**").hasAnyRole("ADMIN","USER")
                    .anyRequest().authenticated()
                )
                .userDetailsService(userService)
                .formLogin(form -> form.permitAll())
                .httpBasic(basic -> {});

                         */return http.build();
    }







/* 
@Bean 
public AuthenticationManager authmanager(AuthenticationConfiguration config)
throws Exception{
return config.getAuthenticationManager();
}
*/

}