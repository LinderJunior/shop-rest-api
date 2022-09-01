package com.linder.shop.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linder.shop.model.Cidade;
import com.linder.shop.model.Estado;
import com.linder.shop.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	//getAll
	public List<Cidade>listarCidade(){
		return cidadeRepository.findAll();	
	}
	//save
	public Cidade salvar(Cidade cidade) {
		cidade.setDataCricao(new Date());
		Cidade cidadeNova = cidadeRepository.save(cidade);
		return cidadeNova;
	}
	//update
	public Cidade atualizar(Cidade cidade) {
		cidade.setDataCricao(new Date());
		Cidade cidadeNova = cidadeRepository.save(cidade);
		return cidadeNova;
	}
	//delete
	public void delete(Long id) {
		Cidade cidade = cidadeRepository.findById(id).get();
		cidadeRepository.delete(cidade);
	}
	//findOne
	public Optional<Cidade>findById(Long id){
		return cidadeRepository.findById(id);
	}
	
}
