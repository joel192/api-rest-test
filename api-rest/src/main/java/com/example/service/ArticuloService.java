package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Articulo;
import com.example.request.ArticuloRequest;

public interface ArticuloService {
	
	Articulo guardar(ArticuloRequest request);
	Articulo actualizar(ArticuloRequest request);
	Optional<Articulo> buscar(int id);
	List mostrarTodos();

}
