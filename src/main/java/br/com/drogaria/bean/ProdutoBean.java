package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private ArrayList<Produto> produtos;
	private ArrayList<Produto> produtosFiltrados;
	
	private Produto produto;
	
	private ArrayList<Fabricante> comboFabricantes;
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public ArrayList<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}
	
	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}
	
	
	
	public void carregarListagem() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar();
		}catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		
		}
	}
	
	public void prepararNovo() {
		try {
			produto = new Produto();
		
			FabricanteDAO dao = new FabricanteDAO();
		
			comboFabricantes = dao.listar();
		} catch (Exception ex ) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		}
	
	public void novo() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.cadastrar(produto);
			produtos = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso");
		} catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
	}
	
	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.remover(produto.getCodigo());
			produtos = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Produto removido com sucesso.");
		}catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararEditar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			comboFabricantes = dao.listar();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
	}
	
	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			
			dao.atualizar(produto);
			
			produtos=dao.listar();
			JSFUtil.adicionarMensagemErro("Produto editado com sucesso");
		}catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
}
