package com.seuprojeto.produtos.produtos.mapper;

import com.seuprojeto.produtos.produtos.dto.CategoriaRequest;
import com.seuprojeto.produtos.produtos.dto.CategoriaResponse;
import com.seuprojeto.produtos.produtos.entity.Categoria;

public class CategoriaMapper {
    public static Categoria toEntity(CategoriaRequest dto) {
        Categoria c = new Categoria();
        c.setNome(dto.getNome());
        c.setDescricao(dto.getDescricao());
        return c;
    }
    public static CategoriaResponse toResponse(Categoria entity) {
        CategoriaResponse dto = new CategoriaResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        return dto;
    }
}
