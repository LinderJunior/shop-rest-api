package com.linder.shop.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linder.shop.model.Permissao;
import com.linder.shop.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	//findAll
	public List<Permissao>findAll(){
		return permissaoRepository.findAll();
	}
	
	//save
	public Permissao save(Permissao permissao) {
		permissao.setDataCriacao(new Date());
		Permissao novaPermissao = permissaoRepository.save(permissao);
		return novaPermissao;
	}
	
	//update
	public Permissao update(Permissao permissao) {
		permissao.setDataCriacao(new Date());
		Permissao novaPermissao = permissaoRepository.save(permissao);
		return novaPermissao;
	}
	
	//delete
	public void delete(Long id) {
		Permissao permissao = permissaoRepository.findById(id).get();
		permissaoRepository.delete(permissao);
	}
	
	
	
	
	
	
	
}
