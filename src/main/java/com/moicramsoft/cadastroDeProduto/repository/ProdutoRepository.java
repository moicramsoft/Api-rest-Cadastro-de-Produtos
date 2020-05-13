package com.moicramsoft.cadastroDeProduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moicramsoft.cadastroDeProduto.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Produto findById(long id);
	
}
