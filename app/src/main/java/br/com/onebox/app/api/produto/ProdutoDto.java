package br.com.onebox.app.api.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.onebox.app.api.categoria.CategoriaDto;
import br.com.onebox.app.api.pedido.PedidoDto;
import br.com.onebox.app.domain.pedido.Pedido;
import br.com.onebox.app.domain.produto.Produto;

public class ProdutoDto {

	private Long id;

	private String nome;

	private BigDecimal preco;

	private String descricao;

	private Integer quantidadeEstoque;

	private CategoriaDto categoria;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.descricao = produto.getDescricao();
		this.quantidadeEstoque = produto.getQuantidadeEstoque();
		this.categoria = new CategoriaDto(produto.getCategoria());
	}
	
	public static List<ProdutoDto> converter(List<Produto> objs) {
		List<ProdutoDto> retorno = new ArrayList<>();
		objs.forEach(obj -> retorno.add(new ProdutoDto(obj)));
		return retorno;
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

}
