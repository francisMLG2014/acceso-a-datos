package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Temporada;
import util.ConnectionBD;

public class TemporadaDao implements Dao<Temporada>{
	
	private static Connection connection;

	public ArrayList<Temporada> buscarTodos() {
		connection=openConnection();
		
		closeConnection();
		return null;
	}

	public Temporada buscarPorId(int i) {
		connection=openConnection();
		closeConnection();
		
		return null;
	}

	public void insertar(Temporada t) {
		connection=openConnection();
		
		
		
		closeConnection();
	}

	public void modificar(Temporada t) {
		connection=openConnection();
		closeConnection();
		
	}

	public void borrar(Temporada t) {
		connection=openConnection();
		closeConnection();
		
	}
	
	private static Connection openConnection() {
		ConnectionBD dbconnection=new ConnectionBD();
		connection = dbconnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		try {
			if(connection!=null) {
				connection.close();
				connection=null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 

}
