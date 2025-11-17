package com.seuprojeto.produtos.produtos.dto;

public class PedidoResponse {

    private Long id;
    private Long clienteId;
    private Long produtoId;
    private int quantidade;

    public PedidoResponse() {}

    public PedidoResponse(Long id, Long clienteId, Long produtoId, int quantidade) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
