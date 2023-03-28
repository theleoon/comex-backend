package br.com.onebox.app.api.categoria;

import javax.validation.constraints.NotEmpty;

import br.com.onebox.app.domain.produto.Categoria;

public class CategoriaForm {
	
	@NotEmpty
	private String nome;
	
	public Categoria toEntity() {
		return new Categoria(this.getNome());
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
