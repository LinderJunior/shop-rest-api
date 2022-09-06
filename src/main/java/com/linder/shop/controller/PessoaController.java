package com.linder.shop.controller;

import java.util.List;

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

import com.linder.shop.model.Pessoa;
import com.linder.shop.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	//findAll
	@GetMapping("pessoas")
	public List<Pessoa> listar(){
		return pessoaService.list();
	}
	
	//save 
	@PostMapping("/save")
	public Pessoa save(@RequestBody Pessoa pessoa) {
		return pessoaService.save(pessoa);
	}
	
	//update
	@PutMapping("/update")
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return pessoaService.save(pessoa);
	}
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		pessoaService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delected sucessfull");
		
	}
	
	
	
	
}
