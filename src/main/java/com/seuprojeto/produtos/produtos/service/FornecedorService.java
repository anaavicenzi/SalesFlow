package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.FornecedorRequest;
import com.seuprojeto.produtos.produtos.dto.FornecedorResponse;
import com.seuprojeto.produtos.produtos.entity.Fornecedor;
import com.seuprojeto.produtos.produtos.repository.FornecedorRepository;
import com.seuprojeto.produtos.produtos.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;
    private final PedidoRepository pedidoRepository;

    public FornecedorService(FornecedorRepository repository, PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
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

    public FornecedorResponse buscarPorId(Long id) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
        return new FornecedorResponse(fornecedor.getId(), fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getTelefone());
    }

    public FornecedorResponse atualizar(Long id, FornecedorRequest request) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
        fornecedor.setNome(request.getNome());
        fornecedor.setEmail(request.getEmail());
        fornecedor.setTelefone(request.getTelefone());
        fornecedor = repository.save(fornecedor);
        return new FornecedorResponse(fornecedor.getId(), fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getTelefone());
    }

    public void excluir(Long id) {
        Fornecedor fornecedor = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

        if (pedidoRepository.existsByProdutoFornecedor(fornecedor)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível excluir fornecedor com pedidos atrelados");
        }

        repository.delete(fornecedor);
    }
}
