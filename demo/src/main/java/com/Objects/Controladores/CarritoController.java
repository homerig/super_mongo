package com.Objects.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Objects.Repositorios.*;
import com.Objects.modulos.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carritos")
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping
    public ResponseEntity<Carrito> crearCarrito() {
        Carrito carrito = new Carrito();
        return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.CREATED);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCarritoPorId(@PathVariable String id) {
        Optional<Carrito> carrito = carritoRepository.findById(id);
        if (!carrito.isPresent()) {
            return new ResponseEntity<>("Carrito no encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carrito.get(), HttpStatus.OK);
    }

    @PostMapping("/{carritoId}/productos/{productoId}")
    public ResponseEntity<?> agregarProductoAlCarrito(@PathVariable String carritoId, @PathVariable String productoId) {
        try {
            Optional<Carrito> carritoOptional = carritoRepository.findById(carritoId);
            Optional<Producto> productoOptional = productoRepository.findById(productoId);

            if (!carritoOptional.isPresent()) {
                return new ResponseEntity<>("Carrito no encontrado", HttpStatus.NOT_FOUND);
            }

            if (!productoOptional.isPresent()) {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }

            Carrito carrito = carritoOptional.get();
            Producto producto = productoOptional.get();
            carrito.getProductos().add(producto);

            return new ResponseEntity<>(carritoRepository.save(carrito), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
    
