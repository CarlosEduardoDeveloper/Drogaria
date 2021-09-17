package br.com.drogaria.test;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DaoException;

public class ProdutoDAOTeste {
	
	@Test
	@Ignore
	public void cadastrar() throws DaoException {
		Produto p = new Produto();
		p.setDescricao("NOVALGINA COM 10 COMPRIMIDOS");
		p.setPreco(2.45d);
		p.setQuantidade(13);
		
		Fabricante f = new Fabricante();
		f.setCodigo(2);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.cadastrar(p);
	}
	
	@Test
	@Ignore
    public void listar() throws DaoException {
        ProdutoDAO dao = new ProdutoDAO();
        ArrayList<Produto> lista = dao.listar();

        for(Produto p: lista) {
            System.out.println("Código do Produto: " + p.getCodigo());
            System.out.println("Descrição do Produto: " + p.getDescricao());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("Quantidade: " + p.getFabricante().getCodigo());
            System.out.println("Descrição do Fabricante: " + p.getFabricante().getDescricao());
            System.out.println();
        }
    }
	
	@Test
	@Ignore
	public void remover() throws DaoException {
		Produto p = new Produto();
		p.setDescricao("NOVALGINA COM 10 COMPRIMIDOS");
		p.setPreco(2.45d);
		p.setQuantidade(13);
		
		Fabricante f = new Fabricante();
		f.setCodigo(2);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.remover(p.getCodigo());
	}
	
	@Test
	@Ignore
	public void atualizar() throws DaoException {
		Produto p = new Produto();
		p.setDescricao("NOVALGINA COM 10 COMPRIMIDOS");
		p.setPreco(2.45d);
		p.setQuantidade(13);
		
		Fabricante f = new Fabricante();
		f.setCodigo(2);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.atualizar(p);
	}
	
}
