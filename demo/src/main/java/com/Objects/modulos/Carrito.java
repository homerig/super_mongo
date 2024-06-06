package com.Objects.modulos;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Carrito {
    
    @Id
    private String id;
    private List<Producto> productos;

    public Carrito() {
        
        this.productos = new ArrayList<>();
    }
    public String getUserId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        this.productos.remove(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
    public double getTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}

