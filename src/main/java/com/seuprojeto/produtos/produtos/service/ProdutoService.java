package com.seuprojeto.produtos.produtos.service;

import com.seuprojeto.produtos.produtos.dto.ProdutoRequest;
import com.seuprojeto.produtos.produtos.dto.ProdutoResponse;
import com.seuprojeto.produtos.produtos.entity.Categoria;
import com.seuprojeto.produtos.produtos.entity.Fornecedor;
import com.seuprojeto.produtos.produtos.entity.Produto;
import com.seuprojeto.produtos.produtos.mapper.ProdutoMapper;
import com.seuprojeto.produtos.produtos.repository.CategoriaRepository;
import com.seuprojeto.produtos.produtos.repository.FornecedorRepository;
import com.seuprojeto.produtos.produtos.repository.ProdutoRepository;
import com.seuprojeto.produtos.produtos.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final FornecedorRepository fornecedorRepository;
    private final PedidoRepository pedidoRepository;

    public ProdutoService(ProdutoRepository repository, CategoriaRepository categoriaRepository, FornecedorRepository fornecedorRepository, PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public ProdutoResponse salvar(ProdutoRequest request) {
        Categoria categoria = categoriaRepository.findById(request.getCategoriaId()).orElseThrow();
        Fornecedor fornecedor = fornecedorRepository.findById(request.getFornecedorId()).orElseThrow();

        Produto produto = ProdutoMapper.toEntity(request, categoria, fornecedor);
        produto = repository.save(produto);

        return ProdutoMapper.toResponse(produto);
    }

    public List<ProdutoResponse> listar() {
        return repository.findAll().stream()
                .map(ProdutoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProdutoResponse buscarPorId(Long id) {
        Produto produto = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        return ProdutoMapper.toResponse(produto);
    }

    public ProdutoResponse atualizar(Long id, ProdutoRequest request) {
        Produto produto = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        Categoria categoria = categoriaRepository.findById(request.getCategoriaId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria inválida"));
        Fornecedor fornecedor = fornecedorRepository.findById(request.getFornecedorId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fornecedor inválido"));

        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());
        produto.setEstoque(request.getEstoque());
        produto.setMarca(request.getMarca());
        produto.setAtivo(request.isAtivo());
        produto.setCategoria(categoria);
        produto.setFornecedor(fornecedor);

        produto = repository.save(produto);

        return ProdutoMapper.toResponse(produto);
    }

    public void excluir(Long id) {
        Produto produto = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

        if (pedidoRepository.existsByProduto(produto)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível excluir produto com pedidos atrelados");
        }

        repository.delete(produto);
    }
}
