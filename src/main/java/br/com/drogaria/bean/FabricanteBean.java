package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDao;
import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private ListDataModel<Fabricante> fabricantes;

	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
		FabricanteDao dao = new FabricanteDao();
		ArrayList<Fabricante> lista = (ArrayList<Fabricante>) dao.listar();
		fabricantes = new ListDataModel<Fabricante>(lista);
	} catch (Exception ex) {
		
	}
	}
		
	}
