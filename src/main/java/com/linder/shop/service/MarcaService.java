package com.linder.shop.service;
import java.util.List;

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
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
