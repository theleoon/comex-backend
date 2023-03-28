package br.com.onebox.app.repository;

import org.springframework.data.jpa.domain.Specification;

import br.com.onebox.app.domain.cliente.Cliente;

public class SpecificationCliente {
	
	public static Specification<Cliente> nome(String nome){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Cliente> cpf(String cpf){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Cliente> telefone(String telefone){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("telefone"), telefone);
	}

}
