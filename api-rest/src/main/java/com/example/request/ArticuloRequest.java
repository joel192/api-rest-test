package com.example.request;

import javax.validation.constraints.Size;


public class ArticuloRequest {

	private int idArticulo;
	
	@Size(max=20,message="El nombre no puede tener mas de 20 caracteres")
	private String nombre;
	
	@Size(max=200,message="La descripcion no puede tener mas de 200 caracteres")
	private String descripcion;

	private double precio;
	
	@Size(max=10,message="El modelo no puede tener mas de 10 caracteres")
	private String modelo;
	
	public ArticuloRequest() {
		
	}

	public ArticuloRequest(int idArticulo, String nombre, String descripcion, double precio, String modelo) {
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.modelo = modelo;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

}
