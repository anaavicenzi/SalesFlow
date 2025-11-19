package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.ItemPedidoRequest;
import com.seuprojeto.produtos.produtos.dto.ItemPedidoResponse;
import com.seuprojeto.produtos.produtos.entity.ItemPedido;
import com.seuprojeto.produtos.produtos.entity.Pedido;
import com.seuprojeto.produtos.produtos.entity.Produto;
import com.seuprojeto.produtos.produtos.mapper.ItemPedidoMapper;
import com.seuprojeto.produtos.produtos.repository.ItemPedidoRepository;
import com.seuprojeto.produtos.produtos.repository.PedidoRepository;
import com.seuprojeto.produtos.produtos.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemPedidoService(ItemPedidoRepository repository, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public ItemPedidoResponse salvar(ItemPedidoRequest request) {
        Pedido pedido = pedidoRepository.findById(request.getPedidoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pedido inválido"));
        Produto produto = produtoRepository.findById(request.getProdutoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto inválido"));

        ItemPedido ip = ItemPedidoMapper.toEntity(request, pedido, produto);
        ip = repository.save(ip);
        return ItemPedidoMapper.toResponse(ip);
    }

    public List<ItemPedidoResponse> listar() {
        return repository.findAll().stream().map(ItemPedidoMapper::toResponse).collect(Collectors.toList());
    }

    public ItemPedidoResponse buscarPorId(Long id) {
        ItemPedido ip = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ItemPedido não encontrado"));
        return ItemPedidoMapper.toResponse(ip);
    }

    public ItemPedidoResponse atualizar(Long id, ItemPedidoRequest request) {
        ItemPedido ip = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ItemPedido não encontrado"));
        Pedido pedido = pedidoRepository.findById(request.getPedidoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pedido inválido"));
        Produto produto = produtoRepository.findById(request.getProdutoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto inválido"));

        ip.setPedido(pedido);
        ip.setProduto(produto);
        ip.setQuantidade(request.getQuantidade());
        ip.setPrecoUnitario(request.getPrecoUnitario());

        ip = repository.save(ip);
        return ItemPedidoMapper.toResponse(ip);
    }

    public void excluir(Long id) {
        ItemPedido ip = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ItemPedido não encontrado"));
        repository.delete(ip);
    }
}
