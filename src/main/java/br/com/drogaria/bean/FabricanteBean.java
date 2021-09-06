package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private ListDataModel<Fabricante> Fabricantes;

	public ListDataModel<Fabricante> getFabricantes() {
		return Fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		Fabricantes = fabricantes;
	}
	
	
	
}
