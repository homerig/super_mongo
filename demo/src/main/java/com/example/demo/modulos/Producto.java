package com.example.demo.modulos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Producto")

public class Producto {
	@Id
	private String id;
	private String nombre;
	private String descripcion;
	private String comentario;
	private double precio;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
