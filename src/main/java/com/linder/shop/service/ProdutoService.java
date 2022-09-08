package com.linder.shop.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linder.shop.model.Produto;
import com.linder.shop.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	
	//findAll
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	//save
	public Produto save(Produto produto) {
		produto.setDataCriacao(new Date());
		Produto novoProduto = produtoRepository.save(produto);
		return  novoProduto;
	}
	
	//update
	public Produto update(Produto produto) {
		produto.setDataCriacao(new Date());
		Produto novoProduto = produtoRepository.save(produto);
		return  novoProduto;
	}
	
	//delete 
	public void delete(Long id) {
		Produto produto = produtoRepository.findById(id).get();
		produtoRepository.delete(produto);
	}
}
