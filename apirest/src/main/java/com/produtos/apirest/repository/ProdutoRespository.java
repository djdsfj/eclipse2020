package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRespository extends JpaRepository<Produto, Long> {

	
	Produto findByid(long id); 
}
