package com.example.ferre_ixtacZ.entity;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="articulos")
public class Articulos {


@Id     //LLAVE primaaria de la tabla 
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long id;
@Column(name="articulo_nombre")
private String artnom;
@Column(name="precio")
private double pre;
@Column(name="existencias")
private Integer exis;

@Override
public String toString(){

    return "Articulo {"+id +" ,nombre "+artnom+ ",precio"+pre+" ,existencias "+exis+" }";

}



} 

