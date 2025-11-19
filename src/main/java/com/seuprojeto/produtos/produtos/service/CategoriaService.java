package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.CategoriaRequest;
import com.seuprojeto.produtos.produtos.dto.CategoriaResponse;
import com.seuprojeto.produtos.produtos.entity.Categoria;
import com.seuprojeto.produtos.produtos.mapper.CategoriaMapper;
import com.seuprojeto.produtos.produtos.repository.CategoriaRepository;
import com.seuprojeto.produtos.produtos.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final ProdutoRepository produtoRepository;

    public CategoriaService(CategoriaRepository repository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    public CategoriaResponse salvar(CategoriaRequest request) {
        Categoria categoria = CategoriaMapper.toEntity(request);
        categoria = repository.save(categoria);
        return CategoriaMapper.toResponse(categoria);
    }

    public List<CategoriaResponse> listar() {
        return repository.findAll()
                .stream()
                .map(CategoriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CategoriaResponse buscarPorId(Long id) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
        return CategoriaMapper.toResponse(categoria);
    }

    public CategoriaResponse atualizar(Long id, CategoriaRequest request) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
        categoria.setNome(request.getNome());
        categoria.setDescricao(request.getDescricao());
        categoria.setAtivo(request.isAtivo());
        categoria = repository.save(categoria);
        return CategoriaMapper.toResponse(categoria);
    }

    public void excluir(Long id) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));

        if (produtoRepository.existsByCategoria(categoria)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível excluir categoria com produtos relacionados");
        }

        repository.delete(categoria);
    }
}
