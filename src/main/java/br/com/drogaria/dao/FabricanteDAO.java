package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JPAUtil;

public class FabricanteDAO {

	private EntityManager em;

//	public FabricanteDAO(EntityManager em) {
//		this.em = em;
//	}

	public void cadastrar(Fabricante fabricante) throws DaoException {
        try {

            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();

            this.em.persist(fabricante);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new DaoException("Erro ao cadastrar");
        } finally {
            em.close();
        }
    }

//	public Fabricante buscar(int id) throws DaoException {
//		try {
//			em = JPAUtil.getEntityManager();
//			em.getTransaction().begin();
//			return em.find(Fabricante.class, id);
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			em.close();		
//		}
//		return null;
//	}
	
	public Fabricante buscar(int id) {
        if (em == null || !em.isOpen()) {
            em = JPAUtil.getEntityManager(); /// sempre colocar nos métodos...
        }
        return em.find(Fabricante.class, id);
    }
	
	public void remover(int codigo) throws DaoException {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
//			this.em.remove(em.find(Fabricante.class, codigo));
			
			Fabricante fabricanteBuscado = this.buscar(codigo);
			this.em.remove(fabricanteBuscado);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();		
		}
	}
	
	public void atualizar(Fabricante fabricante) throws DaoException {
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
	
	public List<Fabricante> listar() throws DaoException{
        EntityManager em = JPAUtil.getEntityManager();

        try {
        String queryList = "SELECT f FROM Fabricante f ORDER BY descricao ASC";
        List<Fabricante> fabricanteList = em
                .createQuery(queryList, Fabricante.class)
                .getResultList();

        return fabricanteList;
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao listar");
        } finally {
            em.close();
        }

        return null;
    }

    public List<Fabricante> buscarPorDesc(String desc) throws DaoException{
        EntityManager em = JPAUtil.getEntityManager();

        try {
        String queryList = "SELECT f FROM Fabricante f WHERE f.descricao LIKE :descricao";
        List<Fabricante> fabricanteList = em
                .createQuery(queryList, Fabricante.class)
                .setParameter("descricao", "%" + desc + "%")
                .getResultList();

        return fabricanteList;

        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro na pesquisa");
        } finally {
            em.close();
        }
        return null;
    }

//	public void remover(Fabricante fabricante) throws DaoException {
//		// TODO Auto-generated method stub
//		
//	}

//	public void editar(Fabricante fabricante) {
//		// TODO Auto-generated method stub
//		
//	}

}