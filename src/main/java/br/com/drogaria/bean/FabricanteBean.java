package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DaoException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	
	private Fabricante fabricante;
	private ArrayList<Fabricante> fabricantes;
	private ArrayList<Fabricante> fabricantesFiltrados;
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
		
	public ArrayList<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ArrayList<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public ArrayList<Fabricante> getFabricantesFiltrados() {
		return fabricantesFiltrados;
	}

	public void setFabricantesFiltrados(ArrayList<Fabricante> fabricantesFiltrados) {
		this.fabricantesFiltrados = fabricantesFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
		FabricanteDAO dao = new FabricanteDAO();
		fabricantes = (ArrayList<Fabricante>) dao.listar();
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

            fabricantes = (ArrayList<Fabricante>) dao.listar();

            JSFUtil.adicionarMensagemSucesso("Fabricante Salvo Com Sucesso!");

        } catch (DaoException e) {
            e.printStackTrace();
            JSFUtil.adicionarMensagemErro(e.getMessage());

        }

    }
	

	
	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.remover(fabricante.getCodigo());
			
			fabricantes = (ArrayList<Fabricante>) dao.listar();
				
			JSFUtil.adicionarMensagemSucesso("Fabricante removido com sucesso!");
		} catch (Exception ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());	
			}
				
		}
	
	
	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.atualizar(fabricante);
			
			fabricantes = (ArrayList<Fabricante>) dao.listar();
			 
			JSFUtil.adicionarMensagemSucesso("Fabricante editado com sucesso!");
		} catch (Exception ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());	
			}
	}
	
	}
	
