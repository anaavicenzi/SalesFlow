package com.seuprojeto.produtos.produtos.entity;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private double preco;

    private int estoque;

    private String marca;

    private boolean ativo;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Fornecedor fornecedor;  // ✅ FALTAVA

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

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Fornecedor getFornecedor() { return fornecedor; }  // ✅ FALTAVA
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; } // ✅ FALTAVA
}
