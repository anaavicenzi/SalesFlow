package com.seuprojeto.produtos.produtos.mapper;

import com.seuprojeto.produtos.produtos.dto.ProdutoRequest;
import com.seuprojeto.produtos.produtos.dto.ProdutoResponse;
import com.seuprojeto.produtos.produtos.entity.Produto;
import com.seuprojeto.produtos.produtos.entity.Categoria;
import com.seuprojeto.produtos.produtos.entity.Fornecedor;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequest dto, Categoria categoria, Fornecedor fornecedor) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setPreco(dto.getPreco());
        p.setEstoque(dto.getEstoque());
        p.setMarca(dto.getMarca());
        p.setAtivo(dto.isAtivo());
        p.setCategoria(categoria);
        p.setFornecedor(fornecedor);
        return p;
    }

    public static ProdutoResponse toResponse(Produto entity) {
        ProdutoResponse dto = new ProdutoResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setPreco(entity.getPreco());
        dto.setEstoque(entity.getEstoque());
        dto.setMarca(entity.getMarca());
        dto.setAtivo(entity.isAtivo());
        dto.setCategoriaId(entity.getCategoria() != null ? entity.getCategoria().getId() : null);
        dto.setFornecedorId(entity.getFornecedor() != null ? entity.getFornecedor().getId() : null);
        return dto;
    }
}
