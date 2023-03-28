package br.com.onebox.app.enums;

import java.math.BigDecimal;

import br.com.onebox.app.domain.pedido.Pedido;
import br.com.onebox.app.domain.produto.Produto;

public enum AplicaDescontoItemDePedido {
	
	PROMOCAO(new BigDecimal("0.6")), 
	FIDELIDADE(new BigDecimal("0.9")), 
	QUANTIDADE(new BigDecimal("0.5")),
	BANCO(new BigDecimal("0.5")), 

	NENHUM(BigDecimal.ONE);
	
	BigDecimal desconto;

	AplicaDescontoItemDePedido(BigDecimal valorDoDesconto) {
		this.desconto = valorDoDesconto;
	}

	public BigDecimal aplicaDescontoSobre(Produto produto) {
		return produto.getPreco().multiply(desconto);
	}
	
	public BigDecimal aplicaDescontoSobre(Pedido pedido) {
		return pedido.getTotalPedido().multiply(desconto);
	}

}
