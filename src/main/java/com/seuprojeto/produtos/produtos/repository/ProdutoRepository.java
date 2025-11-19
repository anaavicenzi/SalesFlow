package com.seuprojeto.produtos.produtos.repository;

import com.seuprojeto.produtos.produtos.entity.Categoria;
import com.seuprojeto.produtos.produtos.entity.Produto;
import com.seuprojeto.produtos.produtos.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria(Categoria categoria);
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByEstoqueLessThan(int estoque);

    // Checagens rápidas usadas antes de excluir categorias/fornecedores
    boolean existsByCategoria(Categoria categoria);
    boolean existsByFornecedor(Fornecedor fornecedor);
}
