package com.seuprojeto.produtos.produtos.repository;

import com.seuprojeto.produtos.produtos.entity.Cliente;
import com.seuprojeto.produtos.produtos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByCliente(Cliente cliente);
    List<Pedido> findByDataPedidoBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}
