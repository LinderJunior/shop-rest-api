package com.linder.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linder.shop.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
