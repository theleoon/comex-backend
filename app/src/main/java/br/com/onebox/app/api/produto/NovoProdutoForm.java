package br.com.onebox.app.api.produto;

import java.math.BigDecimal;

import br.com.onebox.app.api.categoria.CategoriaDto;
import br.com.onebox.app.domain.produto.Produto;

public class NovoProdutoForm {

	private Long id;

	private String nome;

	private BigDecimal preco;

	private String descricao;

	private Integer quantidadeEstoque;

	private CategoriaDto categoria;
	
	public Produto toEntity() {
		return new Produto(nome, preco, descricao, quantidadeEstoque, categoria.converter());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}

}
