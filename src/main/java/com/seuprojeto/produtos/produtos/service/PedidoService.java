package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.PedidoRequest;
import com.seuprojeto.produtos.produtos.dto.PedidoResponse;
import com.seuprojeto.produtos.produtos.entity.Cliente;
import com.seuprojeto.produtos.produtos.entity.Pedido;
import com.seuprojeto.produtos.produtos.entity.Produto;
import com.seuprojeto.produtos.produtos.mapper.PedidoMapper;
import com.seuprojeto.produtos.produtos.repository.ClienteRepository;
import com.seuprojeto.produtos.produtos.repository.PedidoRepository;
import com.seuprojeto.produtos.produtos.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository repository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public PedidoResponse salvar(PedidoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow();
        Produto produto = produtoRepository.findById(request.getProdutoId()).orElseThrow();

        Pedido pedido = PedidoMapper.toEntity(request, cliente, produto);
        pedido = repository.save(pedido);

        return PedidoMapper.toResponse(pedido);
    }

    public List<PedidoResponse> listar() {
        return repository.findAll().stream()
                .map(PedidoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PedidoResponse buscarPorId(Long id) {
        Pedido pedido = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        return PedidoMapper.toResponse(pedido);
    }

    public PedidoResponse atualizar(Long id, PedidoRequest request) {
        Pedido pedido = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inválido"));
        Produto produto = produtoRepository.findById(request.getProdutoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto inválido"));

        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(request.getQuantidade());

        pedido = repository.save(pedido);

        return PedidoMapper.toResponse(pedido);
    }

    public void excluir(Long id) {
        Pedido pedido = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        repository.delete(pedido);
    }
}
