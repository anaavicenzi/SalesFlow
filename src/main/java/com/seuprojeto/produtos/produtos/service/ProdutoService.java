package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.ProdutoRequest;
import com.seuprojeto.produtos.produtos.dto.ProdutoResponse;
import com.seuprojeto.produtos.produtos.entity.Categoria;
import com.seuprojeto.produtos.produtos.entity.Fornecedor;
import com.seuprojeto.produtos.produtos.entity.Produto;
import com.seuprojeto.produtos.produtos.mapper.ProdutoMapper;
import com.seuprojeto.produtos.produtos.repository.CategoriaRepository;
import com.seuprojeto.produtos.produtos.repository.FornecedorRepository;
import com.seuprojeto.produtos.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final FornecedorRepository fornecedorRepository;

    public ProdutoService(ProdutoRepository repository, CategoriaRepository categoriaRepository, FornecedorRepository fornecedorRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public ProdutoResponse salvar(ProdutoRequest request) {
        Categoria categoria = categoriaRepository.findById(request.getCategoriaId()).orElseThrow();
        Fornecedor fornecedor = fornecedorRepository.findById(request.getFornecedorId()).orElseThrow();

        Produto produto = ProdutoMapper.toEntity(request, categoria, fornecedor);
        produto = repository.save(produto);

        return ProdutoMapper.toResponse(produto);
    }

    public List<ProdutoResponse> listar() {
        return repository.findAll().stream()
                .map(ProdutoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
