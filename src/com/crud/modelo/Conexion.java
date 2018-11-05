package com.crud.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
		private final String url ="jdbc:mysql://127.0.0.1:3306/generacion?useUnicode=true&characterEncoding=utf8";
		private final String user = "root";
		private final String password ="2804";
		
		public Connection getConnection() {
			
			Connection con = null;
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con= (Connection) DriverManager.getConnection(url, user, password);
				
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return con;
		}

}
