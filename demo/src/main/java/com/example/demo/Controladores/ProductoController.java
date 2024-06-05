package com.example.demo.Controladores;
import com.example.demo.modulos.Producto;
import com.example.demo.Repositorios.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Producto")
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}
	@PostMapping
	public Producto createProducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	

}
