package br.com.onebox.app.domain.pedido;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.onebox.app.domain.produto.Produto;
import br.com.onebox.app.domain.produto.TipoDescontoProdutoEnum;

@Entity
@Table(name = "itens_pedido")
public class ItemDePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

	@Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    
	@Column(name = "quantidade")
    private int quantidade;
	
	@Column(name = "desconto")
	private BigDecimal desconto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_desconto")
	private TipoDescontoProdutoEnum tipoDesconto;
	
	/** 
	 * @deprecated Hibernate only */
	public ItemDePedido() {}
	
	public ItemDePedido(Produto produto, int quantidade, BigDecimal desconto,
			TipoDescontoProdutoEnum tipoDesconto) {
		this.produto = produto;
		this.precoUnitario = produto.getPreco();
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.tipoDesconto = tipoDesconto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public TipoDescontoProdutoEnum getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDescontoProdutoEnum tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public BigDecimal getTotal() {
		return getPrecoUnitario().multiply(new BigDecimal(getQuantidade())).subtract(getDesconto());
	}
}
