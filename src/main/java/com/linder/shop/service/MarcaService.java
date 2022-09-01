package com.linder.shop.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linder.shop.model.Marca;
import com.linder.shop.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	MarcaRepository marcaRepository;
	
	//GetAll
	public List<Marca> listar(){
		return marcaRepository.findAll();
	}
	
	//save
	public Marca salvar(Marca marca) {
		marca.setData(new Date());
		Marca novaMarca = marcaRepository.save(marca);
		return novaMarca;
	}
	//update
	public Marca update(Marca marca) {
		marca.setData(new Date());
		Marca novaMarca = marcaRepository.save(marca);
		return novaMarca;
	}
	//delete
	public void deletar(Long id) {
		Marca marca = marcaRepository.findById(id).get();
		marcaRepository.delete(marca);
	}
	
	//getById
	public Optional<Marca> findById(Long id){
		return marcaRepository.findById(id);
	}

	
}
