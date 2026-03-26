package com.example.ferre_ixtacZ.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferre_ixtacZ.entity.Articulos;
import com.example.ferre_ixtacZ.entity.Usuario;
@Repository
public interface repo_usuarios extends JpaRepository<Usuario, Long> {

Optional<Usuario>findByUsuario(String nombreusuario);


}



 
