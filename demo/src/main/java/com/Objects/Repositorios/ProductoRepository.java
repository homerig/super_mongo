package com.Objects.Repositorios;
import com.Objects.modulos.Producto;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto,String>  {
	List<Producto> findByNombre(String nombre);


}
