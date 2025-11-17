package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.CategoriaRequest;
import com.seuprojeto.produtos.produtos.dto.CategoriaResponse;
import com.seuprojeto.produtos.produtos.entity.Categoria;
import com.seuprojeto.produtos.produtos.mapper.CategoriaMapper;
import com.seuprojeto.produtos.produtos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
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
}

