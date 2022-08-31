package com.linder.shop.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
	
	@PutMapping("/atualizar")
	public Estado atualizar(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluir(@PathVariable("id") Long id) {
		estadoService.delete(id);
		return ResponseEntity.ok().build();
		
	}
	
}
	