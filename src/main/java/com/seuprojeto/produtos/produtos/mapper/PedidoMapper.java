package com.seuprojeto.produtos.produtos.mapper;

import com.seuprojeto.produtos.produtos.dto.PedidoRequest;
import com.seuprojeto.produtos.produtos.dto.PedidoResponse;
import com.seuprojeto.produtos.produtos.entity.Cliente;
import com.seuprojeto.produtos.produtos.entity.Pedido;
import com.seuprojeto.produtos.produtos.entity.Produto;

public class PedidoMapper {

    public static Pedido toEntity(PedidoRequest dto, Cliente cliente, Produto produto) {
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(dto.getQuantidade());
        return pedido;
    }

    public static PedidoResponse toResponse(Pedido entity) {
        return new PedidoResponse(
                entity.getId(),
                entity.getCliente().getId(),
                entity.getProduto().getId(),
                entity.getQuantidade()
        );
    }
}
