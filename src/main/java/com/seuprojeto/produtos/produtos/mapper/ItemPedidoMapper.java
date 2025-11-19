package com.seuprojeto.produtos.produtos.mapper;

import com.seuprojeto.produtos.produtos.dto.ItemPedidoRequest;
import com.seuprojeto.produtos.produtos.dto.ItemPedidoResponse;
import com.seuprojeto.produtos.produtos.entity.ItemPedido;
import com.seuprojeto.produtos.produtos.entity.Pedido;
import com.seuprojeto.produtos.produtos.entity.Produto;

public class ItemPedidoMapper {
    public static ItemPedido toEntity(ItemPedidoRequest dto, Pedido pedido, Produto produto) {
        ItemPedido ip = new ItemPedido();
        ip.setPedido(pedido);
        ip.setProduto(produto);
        ip.setQuantidade(dto.getQuantidade());
        ip.setPrecoUnitario(dto.getPrecoUnitario());
        return ip;
    }

    public static ItemPedidoResponse toResponse(ItemPedido entity) {
        ItemPedidoResponse dto = new ItemPedidoResponse();
        dto.setId(entity.getId());
        dto.setPedidoId(entity.getPedido() != null ? entity.getPedido().getId() : null);
        dto.setProdutoId(entity.getProduto() != null ? entity.getProduto().getId() : null);
        dto.setQuantidade(entity.getQuantidade());
        dto.setPrecoUnitario(entity.getPrecoUnitario());
        return dto;
    }
}
