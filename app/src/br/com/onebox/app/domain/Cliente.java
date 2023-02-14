package br.com.onebox.app.domain;

import java.util.Objects;

public class Cliente {

	private Long id;
	private String primeiroNome;
	private String sobreNome;
	private String cpf;
	private String telefone;
	private String rua;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Cliente(String primeiroNome, String sobreNome, String cpf, String telefone, String rua, Integer numero,
			String complemento, String bairro, String cidade, String estado) {
		this.primeiroNome = primeiroNome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getNomeCompleto() {
		return this.primeiroNome + " " + this.sobreNome;
	}
	
	public String getEnderecoCompleto() {
		return "Endereço Completo [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", primeiroNome=" + primeiroNome + ", sobreNome=" + sobreNome + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

}
