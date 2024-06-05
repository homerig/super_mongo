package com.example.demo.Repositorios;
import com.example.demo.modulos.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	

}
