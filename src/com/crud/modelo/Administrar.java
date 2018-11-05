package com.crud.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;



public class Administrar {
	
		public String agregar(String nombre, String edad) {
			Conexion obj = new Conexion();
			Connection con = obj.getConnection();
			String respuesta ="";
			String sql ="INSERT INTO participantes(nombre,edad)VALUES(?,?)";
			
			
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1,nombre);
				stmt.setString(2,edad);
				int  rs = stmt.executeUpdate();
				if(rs>0)
					respuesta = "Resgistros afectados"+rs;
				
				else 
					respuesta = "no hubo cambios";
				stmt.close();
				con.close();
				
			}catch (Exception  e) {
				
				respuesta = e.getMessage();
			}	
			return respuesta;
			
		}

}
