package com.linder.shop.controller;
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

import com.linder.shop.model.Marca;
import com.linder.shop.repository.EstadoRepository;
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
	//save
	@PostMapping("/salvar")
	public Marca salvar(@RequestBody Marca marca) {
		return marcaService.salvar(marca);
	}
	
	//update
	@PutMapping("/actualizar")
	public Marca actualizar(@RequestBody Marca marca) {
		return marcaService.salvar(marca);
	}
	
	//Delete
	@DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id){
		Optional<Marca>marcaOptional = marcaService.findById(id);
		if(!marcaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca nao encontrada");
		}
    	marcaService.deletar(id);
    	return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }
}
