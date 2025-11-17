package com.seuprojeto.produtos.produtos.repository;

import com.seuprojeto.produtos.produtos.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
