package com.seuprojeto.produtos.produtos.repository;

import com.seuprojeto.produtos.produtos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
