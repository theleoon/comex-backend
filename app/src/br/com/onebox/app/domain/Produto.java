package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import br.com.onebox.app.exception.ProdutoException;

public class Produto implements ValidaCampos {

	private static final BigDecimal PERCENTUAL_TOTAL_DE_IMPOSTOS = new BigDecimal(0.40);

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal precoUnitario;
	private Integer quantidade;
	private Categoria categoria;
	private Integer quantidadeEmEstoque;

	public Produto(String nome, String descricao, BigDecimal precoUnitario, Integer quantidade, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.categoria = categoria;
		validar();
	}
	
	public Produto(String nome, String descricao, BigDecimal precoUnitario, Integer quantidade, Categoria categoria, Integer quantidadeEmEstoque) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		validar();
	}

	public Produto(Long id, String nome, String descricao, BigDecimal precoUnitario, Integer quantidade,
			Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.categoria = categoria;
		validar();
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario
				+ ", quantidade=" + quantidade + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descricao, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		validar();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
		validar();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public BigDecimal getTotalEmEstoque() {
		return this.precoUnitario.multiply(new BigDecimal(this.quantidade)).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getPrecoComImposto() {
		BigDecimal totalComImposto = precoUnitario.add(precoUnitario.multiply(PERCENTUAL_TOTAL_DE_IMPOSTOS));
		return totalComImposto.setScale(2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getValorTotalEmEstoque() {
        return this.precoUnitario.multiply(new BigDecimal(this.quantidadeEmEstoque)).setScale(2, RoundingMode.HALF_UP);
    }

	@Override
	public void validar() throws ProdutoException {
		if (this.nome == "")
			throw new ProdutoException("nome vazio");
		if (this.nome == null)
			throw new ProdutoException("nome nulo");
		if (this.precoUnitario.compareTo(BigDecimal.ZERO) <= 0)
			throw new ProdutoException("O preço do produto não pode ser menor ou igual a zero");
	}

}
