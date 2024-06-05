package com.Objects.Repositorios;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Objects.modulos.Factura;

public interface FacturaRepository extends MongoRepository<Factura,String>{

}
