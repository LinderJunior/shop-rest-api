package com.linder.shop.controller;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linder.shop.model.Estado;
import com.linder.shop.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;
	
	@GetMapping("/estados")
	public List<Estado>listar(){
		return estadoService.listaEstado();	
	}
	
	@PostMapping("/salvar")
	public Estado salvar(@RequestBody Estado estado) {		
		return estadoService.salvar(estado);
	}
	//update 
	@PutMapping("/atualizar")
	public Estado atualizar(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>excluir(@PathVariable("id") Long id) {
		Optional<Estado> estadoOptional = estadoService.findById(id);
		
		if(!estadoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado Nao Encontrado");
		}
		
		estadoService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Estado Deletado com Sucesso");
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Object>findByOne(@PathVariable("id") Long id){
		Optional<Estado>estadoOptional = estadoService.findById(id);
		if(!estadoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado nao econtrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(estadoOptional.get());
	}

}
	