package br.com.drogaria.dao;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;

public class FabricanteDao {

	private EntityManager em;

//	public FabricanteDAO(EntityManager em) {
//		this.em = em;
//	}

	public void cadastrar(Fabricante fabricante) {
		try {
			em = JPAUtil.getEntityManager(); ///sempre colocar nos métodos...
			em.getTransaction().begin();
			this.em.persist(fabricante);
			em.getTransaction().commit();
			System.out.println("Fabricante cadastrado.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Não foi possível cadastrar o fabricante.");
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public Fabricante buscar(int id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			return em.find(Fabricante.class, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();		
		}
		return null;
	}
	
	public void remover(int codigo) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			this.em.remove(em.find(Fabricante.class, codigo));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();		
		}
	}
	
	public void atualizar(Fabricante fabricante) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			this.em.merge(fabricante);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();		
		}
		}

}