package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.ClienteRequest;
import com.seuprojeto.produtos.produtos.dto.ClienteResponse;
import com.seuprojeto.produtos.produtos.entity.Cliente;
import com.seuprojeto.produtos.produtos.mapper.ClienteMapper;
import com.seuprojeto.produtos.produtos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
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
}
