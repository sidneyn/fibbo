package com.fibbo.selecaofibbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fibbo.selecaofibbo.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
