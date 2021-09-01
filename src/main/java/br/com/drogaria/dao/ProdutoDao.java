package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;

public class ProdutoDao {

	private EntityManager em;

//	public ProdutoDao (EntityManager em) {
//		this.em = em;
//	}

	public void cadastrar(Produto produto) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			this.em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public Produto buscarPorId(int id){
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			return em.find(Produto.class, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();		
		}
		return null;
	}
	
	public void remover(Produto produto, int id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			this.em.remove(em.find(Produto.class, id));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();		
		}
	}
	
	public void atualizar(Produto produto) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			this.em.merge(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();		
		}
		}
}