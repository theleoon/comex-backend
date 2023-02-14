package br.com.onebox.app.domain;

public class Categoria {
	
	private Long id;
	private String nome;
	private Boolean status = Boolean.TRUE;
	
	public Categoria(String nome) {
		this.nome = nome;
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


}
