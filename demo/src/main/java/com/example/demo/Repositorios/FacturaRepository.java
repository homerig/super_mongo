package com.example.demo.Repositorios;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modulos.Factura;

public interface FacturaRepository extends MongoRepository<Factura,String>{

}
