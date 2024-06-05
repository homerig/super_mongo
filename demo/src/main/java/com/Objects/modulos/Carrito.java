package com.Objects.modulos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Carritos")
public class Carrito {
    @Id
    private String id;    
    private List<Producto> productos;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }    

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() {
            return productos;
        }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        this.productos.remove(producto);
    }
    
    public double getTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}

