package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Serie;
import pojos.Temporada;
import util.ConnectionBD;

public class SerieDao implements Dao<Serie>{
	
	private static Connection connection;
	
	public SerieDao() {}
	

	public ArrayList<Serie> buscarTodos() {
		ArrayList<Serie> series=new ArrayList<Serie>();
		connection=openConnection();
		closeConnection();
		return null;
	}

	public Serie buscarPorId(int i) {
		connection=openConnection();
		String query="select * from series where id = ?";
		Serie serie=null;
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				serie= new Serie(rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null);//TODO hacer que te devuelva el conteo de todas las temporadas
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return serie;
	}

	public void insertar(Serie t) {
		connection=openConnection();
		String query="insert into series(titulo,edad,plataforma) values(?,?,?);";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, t.getTitulo());
			ps.setInt(2,t.getEdad());
			ps.setString(3, t.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException e) {
			closeConnection();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		closeConnection();
	}

	public void modificar(Serie t) {
		connection=openConnection();
		closeConnection();
	}

	public void borrar(Serie t) {
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
