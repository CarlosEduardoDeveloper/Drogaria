package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;

public class ProdutoDAO {

	private EntityManager em;

//	public ProdutoDAO (EntityManager em) {
//		this.em = em;
//	}

	public void cadastrar(Produto produto) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			this.em.persist(produto);
			em.getTransaction().commit();
			System.out.println("Produto cadastrado.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Não foi possível cadastrar o produto.");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public Produto buscar(int id){
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			return em.find(Produto.class, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();		
		}
		return null;
	}
	
	public void remover(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			this.em.remove(em.find(Produto.class, id));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			em.close();		
		}
		}
}