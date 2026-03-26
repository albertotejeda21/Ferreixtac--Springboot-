package com.example.ferre_ixtacZ.mapper;

import com.example.ferre_ixtacZ.entity.Articulos;
import com.example.ferre_ixtacZ.DTOs.articulosDTO;

public class ArticuloMapper {

    public static articulosDTO toDTO (Articulos articulo){
return new articulosDTO(

    articulo.getId(),
    articulo.getArtnom(),
    articulo.getPre(),
    articulo.getExis()

 );
    }
 public static Articulos toEntity(articulosDTO dto){
Articulos articulo = new Articulos();


articulo.setId(dto.getId());
articulo.setArtnom(dto.getArtnom());
articulo.setPre(dto.getPre());
articulo.setExis(dto.getExistencia());
return articulo;

    }
}