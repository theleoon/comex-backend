package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class ProdutoIsento extends Produto {

    public ProdutoIsento(String nome, String descricao, BigDecimal precoUnitario, Integer quantidade,
			Categoria categoria, Integer quantidadeEmEstoque) {
		super(nome, descricao, precoUnitario, quantidade, categoria, quantidadeEmEstoque);
	}

	public BigDecimal calculaImposto(){
        return BigDecimal.ZERO;
    }
    
}
