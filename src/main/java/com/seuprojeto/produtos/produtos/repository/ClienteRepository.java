package com.seuprojeto.produtos.produtos.repository;

import com.seuprojeto.produtos.produtos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
