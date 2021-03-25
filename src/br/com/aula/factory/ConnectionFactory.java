package br.com.aula.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String driverName = "org.gjt.mm.mysql.Driver";
		Class.forName(driverName);
		
		String serverName = "localhost";
		String password = "secreta";
		String mydatabase = "aula";
		String username = "root";
		String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase;

		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
}