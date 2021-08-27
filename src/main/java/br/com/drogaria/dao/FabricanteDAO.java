package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;

public class FabricanteDAO {
	
	public void salvar(Fabricante f) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao)");
		sql.append("(VALUES(?)");
	}
	
}
