package com.example.ferre_ixtacZ.servicios;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ferre_ixtacZ.DTOs.articulosDTO;
import com.example.ferre_ixtacZ.entity.Articulos;
import com.example.ferre_ixtacZ.mapper.ArticuloMapper;
import com.example.ferre_ixtacZ.repositorio.irepoArticulos;

import java.util.stream.Collector;
import java.util.List;

@Service
public class articuloService {


@Autowired

    private irepoArticulos repo;

//@GetMapping
public List<articulosDTO> consulta(){   
return repo.findAll().stream().map(ArticuloMapper::toDTO)
    .collect(Collectors.toList());
}

  /*primero creamos el obj para convertir dto para que pueda trabjar con la entidad
  hacemos la conversion y esa conversion se la pasamos a articulo
  luego creamos otra variable llamada insertado
  al final hacemos un return articulo maper*/

public articulosDTO serv_inserta (articulosDTO dto){
    Articulos articulo = ArticuloMapper.toEntity(dto);
    Articulos insertado = repo.save(articulo);
    return ArticuloMapper.toDTO(insertado);  
 
}

public articulosDTO serv_edit (articulosDTO iDto){
    Articulos articulo = ArticuloMapper.toEntity(iDto);
    Articulos editado  = repo.save(articulo);
    return ArticuloMapper.toDTO(editado);  

}

    public articulosDTO serv_Actualiza(Long id, articulosDTO dto) {
        Optional<Articulos> existe = repo.findById(id);

        if (existe.isPresent()) {
            Articulos articulo = existe.get();
            
        articulo.setId(dto.getId());
        articulo.setArtnom(dto.getArtnom());
        articulo.setPre(dto.getPre());
        articulo.setExis(dto.getExistencia());

            Articulos actualizado = repo.save(articulo);

            return ArticuloMapper.toDTO(actualizado);
        } else {
            throw new RuntimeException("Articulo no encontrado con id " + id);
        }
    }

//------------------

   public String serv_elimina(long id){

    if (repo.existsById(id)){
        repo.deleteById(id);
        return "Articulo eliminado ";
    }else return "articulo "+id+" no encontrado ";
    }

     public articulosDTO Serv_buscaid(Long id){

    Articulos articulosporId = repo.findById(id)
    .orElseThrow(()-> new RuntimeException ("Articulo con id:"+id+"no encontrado" ));
    return ArticuloMapper.toDTO(articulosporId);} 
    
}

 

    /*  
@GetMapping 
public List<articulosDTO>listarz*/

//}
