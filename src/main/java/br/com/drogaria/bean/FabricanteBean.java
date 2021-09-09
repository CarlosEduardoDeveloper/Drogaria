package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	
	private Fabricante fabricante;
	private ListDataModel<Fabricante> fabricantes;
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
		FabricanteDAO dao = new FabricanteDAO();
		ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
		fabricantes = new ListDataModel<Fabricante>(lista);
	} catch (Exception ex) {
		ex.printStackTrace();
		JSFUtil.adicionarMensagemErro(ex.getMessage());
	}
	}
	
	public void prepararNovo() {
		fabricante = new Fabricante();
	}
	
	public void novo() {
		try {
		FabricanteDAO dao = new FabricanteDAO();
		dao.cadastrar(fabricante);
		
		ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
		fabricantes = new ListDataModel<Fabricante>(lista);
		
		JSFUtil.adicionarMensagemSucesso("Fabricante salvo com sucesso!");
		} catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());	
		}
			
		}
	
	public void prepararExcluir() {
		fabricante = fabricantes.getRowData();
	}
	
	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.remover(fabricante);
			
			ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
			fabricantes = new ListDataModel<Fabricante>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Fabricante removido com sucesso!");
		} catch (Exception ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());	
			}
				
		}
	}
	
