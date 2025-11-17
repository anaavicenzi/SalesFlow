package com.seuprojeto.produtos.produtos.mapper;

import com.seuprojeto.produtos.produtos.dto.ClienteRequest;
import com.seuprojeto.produtos.produtos.dto.ClienteResponse;
import com.seuprojeto.produtos.produtos.entity.Cliente;

public class ClienteMapper {
    public static Cliente toEntity(ClienteRequest dto) {
        Cliente c = new Cliente();
        c.setNome(dto.getNome());
        c.setEmail(dto.getEmail());
        c.setTelefone(dto.getTelefone());
        return c;
    }
    public static ClienteResponse toResponse(Cliente entity) {
        ClienteResponse dto = new ClienteResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        return dto;
    }
}
