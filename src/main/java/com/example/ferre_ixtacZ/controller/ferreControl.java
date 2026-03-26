package com.example.ferre_ixtacZ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ferre_ixtacZ.DTOs.articulosDTO;
import  com.example.ferre_ixtacZ.entity.Articulos;
import com.example.ferre_ixtacZ.mapper.ArticuloMapper;
import com.example.ferre_ixtacZ.repositorio.irepoArticulos;
import com.example.ferre_ixtacZ.repositorio.repoArticulos;
import com.example.ferre_ixtacZ.servicios.articuloService;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/articulo")
public class ferreControl {


    @Autowired
    private irepoArticulos repositorio;
    @Autowired
    private articuloService servicio;


/* */


@GetMapping  
public List<articulosDTO>listar(){
return servicio.consulta();
} 

/* 
@GetMapping 
public List<Articulos>consulta(){
return (List<Articulos>) repositorio.findAll();
}
*/

//resuqest body toma el json y lo convierte en un objeto java 
@PostMapping
public  articulosDTO insertaAArticulo(@RequestBody articulosDTO dto ){

    return servicio.serv_inserta(dto); 
}



@PostMapping("path")
public String postMethodName(@RequestBody String entity) {
    //TODO: process POST request
    
    return entity;
}

/*
yo
@PutMapping("/{id}")
public articulosDTO putMethodName(@PathVariable Long id, @RequestBody articulosDTO dto ) {
    return servicio.serv_edit(dto);
}
 */

@PutMapping("/{id}")
public articulosDTO putMethodName(@PathVariable Long id, @RequestBody articulosDTO dto ) {
    return servicio.serv_Actualiza(id, dto);
}



//eliminar 
@DeleteMapping("/{id}")
public String borrarArticulos(@PathVariable Long id ){
return servicio.serv_elimina(id);
}

//busca
@GetMapping("/{id}")
public articulosDTO buscaid(@PathVariable long id ){
return servicio.Serv_buscaid(id);

}




/* 
@GetMapping("/{id}")
public Articulos  buscarporid(@PathVariable Long id ){
return repositorio.findById(id).orElse(null);
}
*/


}

