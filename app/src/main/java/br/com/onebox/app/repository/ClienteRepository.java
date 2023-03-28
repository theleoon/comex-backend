package br.com.onebox.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.onebox.app.api.cliente.RelatorioClientePedidosVo;
import br.com.onebox.app.api.cliente.RelatorioClientePorMontanteVo;
import br.com.onebox.app.domain.cliente.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente>  {
	
	List<Cliente> findByNome(String nome);
	
	Cliente findByCpf(String cpf);
	
	@Query("select new br.com.onebox.app.api.cliente.RelatorioClientePedidosVo (c.nome, count(p)) from Cliente c join Pedido p on p.cliente = c group by c.id")
    List<RelatorioClientePedidosVo> listaPorMaisPedidos();
	
	@Query("select new br.com.onebox.app.api.cliente.RelatorioClientePorMontanteVo(c.nome, sum(p.totalPedido) as soma, count(p.id)) from Cliente c join Pedido p on p.cliente = c group by c.id order by soma DESC")
	List<RelatorioClientePorMontanteVo> listaPorMaiorValorGasto();	
	

}
