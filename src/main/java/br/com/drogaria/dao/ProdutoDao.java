package br.com.drogaria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JPAUtil;

public class ProdutoDAO {

	private EntityManager em;

	public void cadastrar(Produto produto) throws DaoException {
        try {

            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();

            this.em.persist(produto);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new DaoException("Erro ao cadastrar");
        } finally {
            em.close();
        }
    }

	public Produto buscar(int id) {
        if (em == null || !em.isOpen()) {
            em = JPAUtil.getEntityManager(); /// sempre colocar nos métodos...
        }
        return em.find(Produto.class, id);
    }
	
	public void remover(int codigo) throws DaoException {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
//			this.em.remove(em.find(Fabricante.class, codigo));
			
			Produto produtoBuscado = this.buscar(codigo);
			this.em.remove(produtoBuscado);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();		
		}
	}
	
	public void atualizar(Produto produto) throws DaoException {
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
	
	public ArrayList<Produto> listar() throws DaoException{
		List<Produto> produtos = new ArrayList<Produto>();
        try {
        	 em = JPAUtil.getEntityManager();
             em.getTransaction().begin();
             String queryList = "select p from Produto p INNER JOIN fetch p.fabricante f";
             List<Produto> produtoList = em
                .createQuery(queryList, Produto.class)
                .getResultList();

             produtos.addAll(produtoList);

        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao listar");
            throw new DaoException("Erro 301");
        } finally {
        	em.close();
        }
        return (ArrayList<Produto>) produtos;
	}
	

}