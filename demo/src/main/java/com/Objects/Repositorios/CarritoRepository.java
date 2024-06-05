package com.Objects.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Objects.modulos.Carrito;

@Repository
public interface CarritoRepository extends MongoRepository<Carrito, String> {   
}

