package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Temporada;
import util.ConnectionBD;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada>{
	
	private static Connection connection;

	public ArrayList<Temporada> buscarTodos() {
		SerieDao s=new SerieDao();
		Temporada t=null;
		ArrayList<Temporada> temps=new ArrayList<Temporada>();
		connection=openConnection();
		String query="SELECT * FROM temporadas";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				t=new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo_temporada"),
						s.buscarPorId(rs.getInt("serie_id")));
				//TODO buscar forma de buscar las temporadas con sus respectivas series
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		return null;
	}

	public Temporada buscarPorId(int i) {
		SerieDao s=new SerieDao();
		connection=openConnection();
		String query="SELECT * FROM temporadas WHERE id=?";
		PreparedStatement ps;
		Temporada t=null;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1,i);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				t=new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo_temporada"),
						s.buscarPorId(rs.getInt("serie_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return t;
	}

	public void insertar(Temporada t) {
		connection=openConnection();
		String query="insert into temporadas (num_temporada,titulo_temporada,serie_id) values(?,?,?);";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, t.getNum_temporada());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			closeConnection();
			e.printStackTrace();
		}
		
		
		closeConnection();
	}

	public void modificar(Temporada t) {
		connection=openConnection();
		String query="UPDATE FROM temporadas SET num_temporada=?,titulo_temporada=?,serie_id=? WHERE id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, t.getNum_temporada());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId());
			ps.setInt(4, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
	}

	public void borrar(Temporada t) {
		connection=openConnection();
		String query="DELETE FROM temporadas WHERE id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
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
