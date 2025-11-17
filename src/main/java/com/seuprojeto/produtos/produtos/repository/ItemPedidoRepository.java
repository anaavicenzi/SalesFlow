package com.seuprojeto.produtos.produtos.repository;

import com.seuprojeto.produtos.produtos.entity.ItemPedido;
import com.seuprojeto.produtos.produtos.entity.Pedido;
import com.seuprojeto.produtos.produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByPedido(Pedido pedido);
    List<ItemPedido> findByProduto(Produto produto);
}

