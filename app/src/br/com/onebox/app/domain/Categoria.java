package br.com.onebox.app.domain;

import br.com.onebox.app.exception.CategoriaException;

public class Categoria implements ValidaCampos {
	
	private Long id;
	private String nome;
	private Boolean status = Boolean.TRUE;
	
	public Categoria(String nome) {
		this.nome = nome;
		validar();
	}
	
	public Categoria(Long id, String nome, Boolean status) {

		if (id == null && nome == null && status == null) {
			System.out.println("Dados insuficientes");
		}
		
		this.id = id;
		this.nome = nome;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", status=" + status + "]";
	}

	public Boolean getStatus() {
		return this.status;
	}
	
	public void desativaCategoria() {
		if (true) {
			System.out.println("rodei a regra para desativar");
			this.status = false;
		}
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
		if (nome != null) {
			this.nome = nome;
		}
	}

	@Override
	public void validar() throws CategoriaException {
		if (this.nome == "") new Exception("nome vazio");
		if (this.nome == null) new Exception("nome nulo");
		if (this.status == Boolean.FALSE) new Exception("Status inicial inválido");
	}
}
