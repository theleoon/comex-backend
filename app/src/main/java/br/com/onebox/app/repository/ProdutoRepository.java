package br.com.onebox.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.onebox.app.domain.produto.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	@Query("select p from Produto p where p.quantidadeEstoque > 0")
	public List<Produto> listaDisponiveis();
	
	@Query("select p from Produto p where p.quantidadeEstoque = 0")
	public List<Produto> listaIndisponiveis();

}
