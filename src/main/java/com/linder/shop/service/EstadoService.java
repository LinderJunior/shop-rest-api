package com.linder.shop.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linder.shop.model.Estado;
import com.linder.shop.repository.EstadoRepository;

@Service
public class EstadoService {
	
@Autowired
EstadoRepository estadoRepository;

public List<Estado>listaEstado(){
	return estadoRepository.findAll();		
}

public Estado salvar(Estado estado) {	
	estado.setDataCriacao(new Date());
	estado.setDataAtualizacao(new Date());
	Estado estadoNovo = estadoRepository.save(estado);
	return estadoNovo;
 }


public Estado atualizar(Estado estado) {	
	estado.setDataAtualizacao(new Date());	
	return estadoRepository.save(estado);
 }

public void delete(Long id) {
	Estado estado = estadoRepository.findById(id).get();
    estadoRepository.delete(estado);
}

public Optional<Estado>findById(Long id){
	return estadoRepository.findById(id);
}

}
