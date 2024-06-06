package com.Objects.Controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Objects.Repositorios.*;
import com.Objects.modulos.*;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }


    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> getUsuariosPorNombre(@RequestParam String nombre) {
        List<Usuario> usuarios = usuarioRepository.findByNombre(nombre);
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
	@PostMapping 
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
