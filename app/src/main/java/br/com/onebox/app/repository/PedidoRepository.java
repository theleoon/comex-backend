package br.com.onebox.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.onebox.app.domain.pedido.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>, JpaRepository<Pedido, Long> {
	
	@Query("SELECT p FROM Pedido p join FETCH p.itens as itens "
			+ "join FETCH itens.produto as prod "
			+ "join FETCH prod.categoria as cat")
	public List<Pedido> getAll();
	

}
