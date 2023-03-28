package br.com.onebox.app.api.pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.onebox.app.api.produto.ProdutoDto;
import br.com.onebox.app.domain.pedido.ItemDePedido;
import br.com.onebox.app.domain.produto.TipoDescontoProdutoEnum;

public class ItemDePedidoDto {

	private Long id;

	private ProdutoDto produto;

	private BigDecimal precoUnitario;

	private int quantidade;

	private BigDecimal desconto;

	private TipoDescontoProdutoEnum tipoDesconto;

	public ItemDePedidoDto(ItemDePedido ItemDePedido) {
		this.id = ItemDePedido.getId();
		this.produto = new ProdutoDto(ItemDePedido.getProduto());
		this.precoUnitario = ItemDePedido.getPrecoUnitario();
		this.quantidade = ItemDePedido.getQuantidade();
		this.desconto = ItemDePedido.getDesconto();
		this.tipoDesconto = ItemDePedido.getTipoDesconto();
	}

	public Long getId() {
		return id;
	}

	public ProdutoDto getProduto() {
		return produto;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public TipoDescontoProdutoEnum getTipoDesconto() {
		return tipoDesconto;
	}

	public static List<ItemDePedidoDto> converter(List<ItemDePedido> itens) {
		List<ItemDePedidoDto> retorno = new ArrayList<>();
		itens.forEach(i -> retorno.add(new ItemDePedidoDto(i)));
		return retorno;
	}

}

