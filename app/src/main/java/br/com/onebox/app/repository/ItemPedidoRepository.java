package br.com.onebox.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.onebox.app.domain.pedido.ItemDePedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemDePedido, Long>{

}
