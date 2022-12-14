package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Serie;
import pojos.Temporada;
import util.ConnectionBD;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie>{
	
	private static Connection connection;
	
	public SerieDao() {}
	

	public ArrayList<Serie> buscarTodos() {
		ArrayList<Serie> series=new ArrayList<Serie>();
		connection=openConnection();
		String query="select * from series";
		Serie serie=null;
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				serie= new Serie(rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null);
				series.add(serie);
			}
			
			for(Serie s : series) {
				s.setTemporadas(obtenerTemporadas(s));
			}
		} catch (SQLException e) {
			closeConnection();
			e.printStackTrace();
		}
		
		
		closeConnection();
		return series;
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
						null);
				serie.setTemporadas(obtenerTemporadas(serie));
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
			e.printStackTrace();
		}
		
		
		
		closeConnection();
	}

	public void modificar(Serie t) {
		int id=t.getId();
		String titulo=t.getTitulo();
		int edad= t.getEdad();
		String plataforma=t.getPlataforma();
		connection=openConnection();
		String query="UPDATE series SET titulo=?,edad=?,plataforma=? WHERE id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.setInt(2, edad);
			ps.setString(3, plataforma);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		closeConnection();
	}

	public void borrar(Serie t) {
		connection=openConnection();
		
		
		
		
		closeConnection();
	}
	
	public ArrayList<Temporada> obtenerTemporadas(Serie s){
		ArrayList<Temporada> temps=new ArrayList<Temporada>();
		connection=openConnection();
		String query="SELECT * FROM temporadas WHERE serie_id = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, s.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Temporada t=new Temporada(
						rs.getInt("Id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo"),
						s);
				temps.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		closeConnection();
		return temps;
		
	}
	
	protected Connection openConnection() {
		ConnectionBD dbconnection=new ConnectionBD();
		connection = dbconnection.getConnection();
		return connection;
	}
	
	protected void closeConnection() {
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
