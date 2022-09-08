package com.linder.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linder.shop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
