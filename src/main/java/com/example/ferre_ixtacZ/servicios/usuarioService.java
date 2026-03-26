 package com.example.ferre_ixtacZ.servicios;

import java.util.List;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ferre_ixtacZ.repositorio.repo_usuarios;
@Service
public class usuarioService implements UserDetailsService {

@Autowired
private repo_usuarios repoUsuarios;
@Override
public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
    var usuario = repoUsuarios.findByUsuario(nombreUsuario)
    //findByUsername(nombreUsuario)

        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario));

    return new User(usuario.getUsuario(), usuario.getPassword(),
      List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()) ));
}

}
