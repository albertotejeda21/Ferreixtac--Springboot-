package com.example.ferre_ixtacZ.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "usuarios")


public class Usuario {

@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable=false, unique= true, length= 50)
private String usuario;

@Column(nullable=false, unique= true, length= 255)
private String password ;

@Column(nullable= false, length= 60)
private String rol;


}
