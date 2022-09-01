package com.linder.shop.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linder.shop.model.Marca;
import com.linder.shop.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	
	@Autowired
	MarcaService marcaService;
	
	//GetAll
	@GetMapping("/marcas")
	public List<Marca>listar(){
		return marcaService.listar();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
