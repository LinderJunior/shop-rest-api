package com.linder.shop.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linder.shop.model.Categoria;
import com.linder.shop.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	//findAll
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}	
	//save
	public Categoria salvar(Categoria categoria) {
		categoria.setData(new Date());
		Categoria novacategoria = categoriaRepository.save(categoria);
		return novacategoria;
	}
	//update
	public Categoria update(Categoria categoria) {
		categoria.setData(new Date());
		Categoria novacategoria = categoriaRepository.save(categoria);
		return novacategoria;
	}
	//delete
	public void deletar(Long id) {
		Categoria categoria = categoriaRepository.findById(id).get();
		categoriaRepository.delete(categoria);
	}
	//findById
	public Optional<Categoria> findById(Long id){
		return categoriaRepository.findById(id);
	}
}
