package com.crud.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Administrar extends Conexion {
	
	public String buscar(int id) {
		String respuesta = "";
		Connection con = getConnection();
		String sql = "select * from participantes where id_participantes =?";
		
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				//respuesta +="ID:Nombre:"+rs.getInt(1)+rs.getString("nombre")+"<br> Edad:"+rs.getString("edad");
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			 respuesta = e.getMessage();
		 
			
		}
		
		return respuesta;
	}
		
		
		
		
		


	public String Editar(int id, String nombre, String edad) {
		String respuesta= "";
		Connection con =getConnection();
		
		String sql ="update participantes set nombre =?, edad=? where id_participantes = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nombre);
			
			stmt.setString(2, edad);
			stmt.setInt(3, id);
			int rs = stmt.executeUpdate();
			if(rs>0)
				respuesta = "Registros actualizados"+rs;
			else 
				respuesta = "No Hubo Cambios";
			
		} catch (Exception e) {
			respuesta = e.getMessage();
			
		}
		return respuesta;
		
	}
	
	
	public String borrar(int id) {
		
		String res = "";
		Connection con =getConnection();
		String sql = "DELETE FROM PARTiCIPANTES WHERE id_Participantes =?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,id);
			int rs = stmt.executeUpdate();
			if(rs>0)
				res ="Resgistros afectados;"+rs;
			
			else
				res="no hubo cambios";
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			res = e.getMessage();
			
		}
		
		return res;
	}
	
	
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
