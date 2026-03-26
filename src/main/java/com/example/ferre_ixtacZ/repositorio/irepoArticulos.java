package com.example.ferre_ixtacZ.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ferre_ixtacZ.entity.Articulos;
@Repository
public interface irepoArticulos extends JpaRepository<Articulos, Long> {

}

