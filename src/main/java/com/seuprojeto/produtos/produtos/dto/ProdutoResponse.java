package com.seuprojeto.produtos.produtos.dto;

public class ProdutoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private String marca;
    private boolean ativo;
    private Long categoriaId;
    private Long fornecedorId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getEstoque() { return estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
    public Long getFornecedorId() { return fornecedorId; }
    public void setFornecedorId(Long fornecedorId) { this.fornecedorId = fornecedorId; }
}
