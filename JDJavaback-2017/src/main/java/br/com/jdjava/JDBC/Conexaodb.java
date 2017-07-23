package br.com.jdjava.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexaodb {
	
	public Connection getConnection() {
	     try {
	    	 
	         return DriverManager.getConnection("jdbc:mysql://localhost/jdjavaback2017?useTimezone=true&amp", "root", "");
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

}
