package com.example.logic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Articulo;
import com.example.repository.ArticuloRepository;
import com.example.request.ArticuloRequest;
import com.example.service.ArticuloService;

@Service
public class ArticuloLogic implements ArticuloService{
	
	@Autowired
	ArticuloRepository repo;
	

	@Override
	public Articulo guardar(ArticuloRequest request) {
		// 
		Articulo a = null;
		
		try {
			a =  new Articulo();
			a.setModelo(request.getModelo());
			a.setNombre(request.getNombre());
			a.setPrecio(request.getPrecio());
			a.setDescripcion(request.getDescripcion());
			repo.save(a);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return a;
	}

	@Override
	public Articulo actualizar(ArticuloRequest request) {
		
		Optional<Articulo> a = repo.findById(request.getIdArticulo());
		Articulo item =null;
		if(a.isPresent()) {
			item = a.get();
			item.setModelo(request.getModelo());
			item.setDescripcion(request.getDescripcion());
			
			repo.save(item);
			return item;
		}else {
			return item;
		}

	}

	@Override
	public Optional<Articulo> buscar(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List mostrarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
