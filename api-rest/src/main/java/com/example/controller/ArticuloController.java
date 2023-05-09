package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Articulo;
import com.example.logic.ArticuloLogic;
import com.example.request.ArticuloRequest;

@RestController
@RequestMapping("/api-articulos")
public class ArticuloController {

	@Autowired
	ArticuloLogic srv;

	// http://localhost:8090/Articulo/mostrar-todos GET
	@GetMapping("mostrar")
	public ResponseEntity<List<Articulo>> listar() {
		List<Articulo> list = srv.mostrarTodos();
		return new ResponseEntity<List<Articulo>>(list, HttpStatus.OK);
	}

	// http://localhost:8090/Articulo/buscar-por-id/23 GET
	@GetMapping("buscar-por-id/{id}")
	public ResponseEntity<Articulo> buscar(@PathVariable int id) {
		Optional<Articulo> objeto = srv.buscar(id);

		if (objeto.isPresent()) {

			return new ResponseEntity<Articulo>(objeto.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	// http://localhost:8090/Articulo/guardar POST
	@PostMapping("guardar")
	public ResponseEntity<Articulo> guardar(@RequestBody @Valid ArticuloRequest req) {
		Articulo a = srv.guardar(req);

		if (a != null) {
			return new ResponseEntity<Articulo>(a, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("editar")
	public ResponseEntity<Articulo> actualizar(@RequestBody @Valid ArticuloRequest req) {
		Articulo a = srv.actualizar(req);

		if (a != null) {
			return new ResponseEntity<Articulo>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
