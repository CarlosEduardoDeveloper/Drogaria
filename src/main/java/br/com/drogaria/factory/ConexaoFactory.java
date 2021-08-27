package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory{
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL)
}










//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class ConexaoFactory {
//	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("Drogaria");
//
//    public ConexaoFactory() {
//    }
//
//    public static EntityManager getEntityManager() {
//        return FACTORY.createEntityManager();
//    }
//}
