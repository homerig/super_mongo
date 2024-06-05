package com.example.demo.Repositorios;
import com.example.demo.modulos.Producto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto,String>  {

}
