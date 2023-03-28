package br.com.onebox.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.onebox.app.domain.produto.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	List<Categoria> findByNome(String nome);
	
	List<Categoria> findByAtiva(Boolean ativa);
	
	@Query("SELECT c FROM Categoria c WHERE c.nome = :nome AND c.ativa = :ativa")
	List<Categoria> findByNomeEAtiva(String nome, Boolean ativa);
	
//	@Query(name = "SELECT * FROM categorias WHERE nome = :nome AND status = :ativa", nativeQuery = true)
//	List<Categoria> findByNomeEAtivaSqlNativo(String nome, Boolean ativa);

}
