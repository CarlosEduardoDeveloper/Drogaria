package br.com.drogaria.factory;

import javax.persistence.EntityManager;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {

//		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO();
		FabricanteDAO f = new FabricanteDAO();
//		
		Produto celular = new Produto();
//		celular.setFabricante(f.buscarPorId(1));
//		celular.setDescricao("Muito legal");
//		celular.setPreco(100.00D);
//		celular.setQuantidade(5);
//			
//		dao.cadastrar(celular);
//		
//		Produto celular2 = new Produto();
//		celular2.setFabricante(f.buscarPorId(1));
//		celular2.setDescricao("Muito legal2");
//		celular2.setPreco(200.00D);
//		celular2.setQuantidade(25);
//			
//		dao.cadastrar(celular2);
		
//		celular.getFabricante();
//		dao.remover(1l);
		
	}
}
