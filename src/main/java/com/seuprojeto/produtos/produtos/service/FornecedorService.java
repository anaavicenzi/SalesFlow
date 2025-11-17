package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.FornecedorRequest;
import com.seuprojeto.produtos.produtos.dto.FornecedorResponse;
import com.seuprojeto.produtos.produtos.entity.Fornecedor;
import com.seuprojeto.produtos.produtos.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public FornecedorResponse salvar(FornecedorRequest request) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(request.getNome());
        fornecedor.setEmail(request.getEmail());
        fornecedor.setTelefone(request.getTelefone());

        fornecedor = repository.save(fornecedor);

        return new FornecedorResponse(
                fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getEmail(),
                fornecedor.getTelefone()
        );
    }
}
