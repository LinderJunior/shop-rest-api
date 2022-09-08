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

import com.linder.shop.model.Produto;
import com.linder.shop.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoService produtoService;
	
	//findAll
	@GetMapping("/produtos")
	public List<Produto>findAll(){
		return produtoService.findAll();	
	}
	
	//save
	@PostMapping("/save")
	public Produto save(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	//update
	@PutMapping("/update")
	public Produto update(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id ){
		produtoService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delete successfull");
	}
	
}
