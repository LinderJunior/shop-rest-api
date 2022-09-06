package com.linder.shop.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linder.shop.model.Pessoa;
import com.linder.shop.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//findAll
	public List<Pessoa> list(){
		return pessoaRepository.findAll();
	}
	//save
	public Pessoa save(Pessoa pessoa) {
		pessoa.setDataCriacao(new Date());
		Pessoa novaPessoa = pessoaRepository.save(pessoa);
		return novaPessoa;
	}
	//update
	//save
	public Pessoa update(Pessoa pessoa) {
		pessoa.setDataCriacao(new Date());
		Pessoa novaPessoa = pessoaRepository.save(pessoa);
		return novaPessoa;
	}
	//delete
	public void delete(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).get();
		pessoaRepository.delete(pessoa);
	}
	//findById
	public Optional<Pessoa> findById(Long id){
		return pessoaRepository.findById(id);	
	}
}
