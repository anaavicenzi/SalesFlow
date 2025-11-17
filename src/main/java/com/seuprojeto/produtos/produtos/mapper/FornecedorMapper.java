package com.seuprojeto.produtos.produtos.mapper;

import com.seuprojeto.produtos.produtos.dto.FornecedorRequest;
import com.seuprojeto.produtos.produtos.dto.FornecedorResponse;
import com.seuprojeto.produtos.produtos.entity.Fornecedor;

public class FornecedorMapper {
    public static Fornecedor toEntity(FornecedorRequest dto) {
        Fornecedor f = new Fornecedor();
        f.setNome(dto.getNome());
        f.setEmail(dto.getEmail());
        f.setTelefone(dto.getTelefone());
        return f;
    }
    public static FornecedorResponse toResponse(Fornecedor entity) {
        FornecedorResponse dto = new FornecedorResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        return dto;
    }
}
