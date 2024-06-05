package com.Objects.Controladores;

import com.Objects.Repositorios.CarritoRepository;
import com.Objects.Repositorios.ProductoRepository;
import com.Objects.modulos.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
	private ProductoRepository productoRepository;
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}

    @Autowired
    private CarritoRepository carritoRepository;

    @PostMapping("/agregarProducto/{carritoId}")
    public Carrito agregarProducto(@PathVariable String carritoId, @RequestBody Producto producto) {
        Carrito carrito = carritoRepository.findById(carritoId).orElse(new Carrito()); // Obtener el carrito por ID o crear uno nuevo si no existe
        carrito.agregarProducto(producto);
        carritoRepository.save(carrito); // Guardar el carrito actualizado
        return carrito;
    }

    @DeleteMapping("/eliminarProducto/{carritoId}")
    public Carrito eliminarProducto(@PathVariable String carritoId, @RequestBody Producto producto) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado")); // Obtener el carrito por ID
        carrito.eliminarProducto(producto);
        carritoRepository.save(carrito);
        return carrito;
    }

    @GetMapping("/obtenerCarrito/{carritoId}")
    public Carrito obtenerCarrito(@PathVariable String carritoId) {
        return carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    @GetMapping("/calcularTotal/{carritoId}")
    public double calcularTotal(@PathVariable String carritoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return carrito.getTotal();
    }
}


