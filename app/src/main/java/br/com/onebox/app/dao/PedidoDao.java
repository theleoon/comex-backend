package br.com.onebox.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.com.onebox.app.domain.pedido.Pedido;
import br.com.onebox.app.domain.produto.Produto;
import br.com.onebox.app.util.JPAUtil;

public class PedidoDao implements Dao<Pedido>{

	private EntityManager em = JPAUtil.getEntityManager();

	@Override
	public Pedido buscaPorId(Long id) {
		return em.find(Pedido.class, id);
	}

	@Override
	public void cadastra(Pedido t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void atualiza(Pedido t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public void remove(Pedido t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public List<Pedido> listaTodos() {
		return em.createQuery("select p from Pedido p", Pedido.class).getResultList();
	}

	public Map<Produto, Long> listaProdutosMaisVendidos() {
		
		// TODO precisa ser por ItemPedido > Produto

	    Map<Produto, Long> retorno = new HashMap<>();
	    
	    String jpql = "select p, c from Pedido p join Produto prd on p.categoria = c group by p.id order by p.preco desc";
		
		List<Object[]> consulta = em.createQuery(jpql).getResultList();
		
//			for (Object[] object : consulta) {
//				Produto produto = (Produto) object[0];
//				Categoria categoria = (Categoria) object[1];
//				maisCaroPorCategoria.put(produto, categoria);
//	        }

		return retorno;
	}

}
