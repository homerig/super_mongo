package com.Objects.Repositorios;
import com.Objects.modulos.Usuario;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    List<Usuario> findByNombre(String nombre);
}
