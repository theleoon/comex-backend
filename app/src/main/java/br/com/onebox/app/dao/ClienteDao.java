package br.com.onebox.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.onebox.app.domain.cliente.Cliente;
import br.com.onebox.app.util.JPAUtil;

public class ClienteDao implements Dao<Cliente>{
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteDao.class);
	
	private EntityManager em = JPAUtil.getEntityManager();

	@Override
	public Cliente buscaPorId(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void cadastra(Cliente t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Override
	public void atualiza(Cliente t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	@Override
	public void remove(Cliente t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public List<Cliente> listaTodos() {
		return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}
	
	public List<Cliente> listaTodosComLazy() {
		return em.createQuery("select c from Cliente c JOIN FETCH c.pedidos", Cliente.class).getResultList();
	}
	
	public static void main(String[] args) {
		
//		new ClienteDao().listaTodos();
		new ClienteDao().listaTodosComLazy();
		
	}
	
	public List<Cliente> listaPorNome(String nome) {
		
		if (nome.isEmpty()) throw new RuntimeException();
		
		String jpql = "select c from Cliente c where c.nome = :nome";
		
		return em.createQuery(jpql, Cliente.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public Cliente buscaPorNomeCpf(String nome, String cpf) {
		
		if ((nome != null && nome.isEmpty()) && (cpf != null && cpf.isEmpty())) throw new RuntimeException();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);
		Root<Cliente> from = query.from(Cliente.class);
		Predicate filtros = builder.and();
		
		if (nome != null && !nome.isEmpty()) 
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
			
		if (cpf != null && !cpf.isEmpty()) 
			filtros = builder.and(filtros, builder.equal(from.get("cpf"), cpf));
		
		query.where(filtros);
		
		return em.createQuery(query).getSingleResult();
	}
	
}
