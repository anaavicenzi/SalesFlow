package com.seuprojeto.produtos.produtos.repository;

import com.seuprojeto.produtos.produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
