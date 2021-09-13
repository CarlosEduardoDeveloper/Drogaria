package br.com.drogaria.factory;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;

public class CadastroDeFabricante {
	
	public static void main(String[] args) throws DaoException {
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante Xiaomi = new Fabricante();
//		Xiaomi.setDescricao("Xiaomiiii");
//				
//		dao.cadastrar(Xiaomi);
//		
//		Fabricante Samsung = new Fabricante();
//		Samsung.setDescricao("Samsuuung");
//				
//		dao.cadastrar(Samsung);
		
//		dao.remover(1);
		
//		dao.atualizar("Xiaomi20");

	
		Fabricante f2 = dao.buscar(3);
		f2.setDescricao("Samsung2");
		dao.atualizar(f2);
		
		    }

	}
