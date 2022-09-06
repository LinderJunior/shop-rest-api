package com.linder.shop.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linder.shop.model.Cidade;
import com.linder.shop.service.CidadeService;
import com.linder.shop.service.EstadoService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	CidadeService cidadeService;
	
	@GetMapping("/cidades")
	public List<Cidade> listarCidade(){
		return cidadeService.listarCidade();
	}
	
	@PostMapping("/salvar")
	public Cidade salvar(@RequestBody Cidade cidade) {
		return cidadeService.salvar(cidade);
	}
	
	@PostMapping("/atualizar")
	public Cidade atualizar(@RequestBody Cidade cidade) {
		return cidadeService.atualizar(cidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>excluir(@PathVariable("id") Long id){	
		Optional<Cidade>cidadeOptional = cidadeService.findById(id);
		
		if(!cidadeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade nao Econtrada");
		}
		
		cidadeService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object>findByOne(@PathVariable("id") Long id){
		Optional<Cidade> cidadeOptional = cidadeService.findById(id);
		if(!cidadeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Nao encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cidadeOptional.get());
		
	}
	
}