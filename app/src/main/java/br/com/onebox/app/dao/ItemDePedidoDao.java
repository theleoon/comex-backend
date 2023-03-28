package br.com.onebox.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.onebox.app.domain.pedido.ItemDePedido;
import br.com.onebox.app.util.JPAUtil;

public class ItemDePedidoDao {

	private EntityManager em = JPAUtil.getEntityManager();

	public ItemDePedido buscaPorId(Long id) {
		return em.find(ItemDePedido.class, id);
	}

	public void atualiza(ItemDePedido t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	public void remove(ItemDePedido t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	public List<ItemDePedido> listaTodos() {
		return em.createQuery("select f from ItemDePedido f", ItemDePedido.class).getResultList();
	}

}
