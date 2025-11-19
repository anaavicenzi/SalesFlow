package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.ClienteRequest;
import com.seuprojeto.produtos.produtos.dto.ClienteResponse;
import com.seuprojeto.produtos.produtos.entity.Cliente;
import com.seuprojeto.produtos.produtos.mapper.ClienteMapper;
import com.seuprojeto.produtos.produtos.repository.ClienteRepository;
import com.seuprojeto.produtos.produtos.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final PedidoRepository pedidoRepository;

    public ClienteService(ClienteRepository repository, PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
    }

    public ClienteResponse salvar(ClienteRequest request) {
        Cliente cliente = ClienteMapper.toEntity(request);
        cliente = repository.save(cliente);
        return ClienteMapper.toResponse(cliente);
    }

    public List<ClienteResponse> listar() {
        return repository.findAll().stream()
                .map(ClienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        return ClienteMapper.toResponse(cliente);
    }

    public ClienteResponse atualizar(Long id, ClienteRequest request) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());
        cliente = repository.save(cliente);
        return ClienteMapper.toResponse(cliente);
    }

    public void excluir(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        if (pedidoRepository.existsByCliente(cliente)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível excluir cliente com pedidos criados");
        }

        repository.delete(cliente);
    }
}
