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

import com.linder.shop.model.Categoria;
import com.linder.shop.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	//List
	@GetMapping("/list")
	public List<Categoria> list(){
		return categoriaService.listar();
	}
	
	@PostMapping("/save")
	public Categoria save(@RequestBody Categoria categoria) {
		return categoriaService.salvar(categoria);
	}
	
	@PutMapping("/update")
	public Categoria atualizar(@RequestBody Categoria categoria) {
		return categoriaService.update(categoria);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable("id") Long id){
		categoriaService.deletar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
		
	}
	
	//findByOne
	
	
	
}
