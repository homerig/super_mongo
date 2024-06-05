package com.Objects.Repositorios;
import com.Objects.modulos.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	

}
