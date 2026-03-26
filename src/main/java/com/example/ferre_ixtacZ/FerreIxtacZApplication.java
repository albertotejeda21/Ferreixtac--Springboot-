package com.example.ferre_ixtacZ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

import com.example.ferre_ixtacZ.entity.Articulos;
import com.example.ferre_ixtacZ.repositorio.irepoArticulos;




@SpringBootApplication
public class FerreIxtacZApplication implements CommandLineRunner {
@Autowired
private irepoArticulos repositorio;


	public static void main(String[] args) {
		SpringApplication.run(FerreIxtacZApplication.class, args);
	}


	@Override

public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("aplicacion iniciada correctamente");
	//	throw new UnsupportedOperationException("Unimplemented method 'run'");
	

	List<Articulos> listaArticulos = repositorio.findAll();
	listaArticulos.stream().forEach(articulo -> System.out.println(articulo));
	
}

}