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

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/Producto")

public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
    

    @GetMapping ("/buscar")
    public ResponseEntity<List<Producto>> getProductosPorNombre(@RequestParam String nombre) {
        List<Producto> productos = productoRepository.findByNombre(nombre);
        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
   
}