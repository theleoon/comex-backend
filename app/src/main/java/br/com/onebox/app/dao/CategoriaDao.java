package br.com.onebox.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.onebox.app.domain.produto.Categoria;
import br.com.onebox.app.util.JPAUtil;

public class CategoriaDao implements Dao<Categoria>{
	
	private EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void cadastra(Categoria t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void atualiza(Categoria t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public List<Categoria> listaTodos() {
		return em.createQuery("select f from Categoria f", Categoria.class).getResultList();
	}

	@Override
	public Categoria buscaPorId(Long id) {
		return em.find(Categoria.class, id);
	}

	@Override
	public void remove(Categoria t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

}
