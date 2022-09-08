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

import com.linder.shop.model.Permissao;
import com.linder.shop.service.PermissaoService;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {

	@Autowired
	private PermissaoService permissaoService;
	
	//findAll
	@GetMapping("/list")
	public List<Permissao>findAll(){
		return permissaoService.findAll();
	}
	
	//save
	@PostMapping("/save")
	public Permissao save (@RequestBody Permissao permissao) {
		return permissaoService.save(permissao);
	}
	
	//update
	@PutMapping("/update")
	public Permissao update(@RequestBody Permissao permissao) {
			return permissaoService.update(permissao);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id){
		permissaoService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("deleted successfull");
	}
	
}
