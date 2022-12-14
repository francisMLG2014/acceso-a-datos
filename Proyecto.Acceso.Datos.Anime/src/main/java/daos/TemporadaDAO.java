package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfazDAO;
import pojos.Temporada;

public class TemporadaDAO extends ObjetoDAO implements InterfazDAO<Temporada>{

	public ArrayList<Temporada> buscarTodos() {
		ArrayList<Temporada> temp=new ArrayList<Temporada>();
		Connection c=this.openConnection();
		try {
			String query="SELECT * FROM temporadas";
			PreparedStatement ps=c.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Temporada t=new Temporada(rs.getInt("id"),
										  rs.getInt("numero_temporada"),
										  rs.getString("titulo"),
										  rs.getString("titulo_japones"),
										  rs.getInt("id_anime"),
										  rs.getInt("capitulos"));
				temp.add(t);
			}
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
		
		return temp;
	}

	public Temporada buscarPorId(int i) {
		Temporada t=null;
		Connection c=this.openConnection();
		String query="SELECT * FROM temporadas WHERE id=?";
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				t=new Temporada(rs.getInt("id"),
										  rs.getInt("numero_temporada"),
										  rs.getString("titulo"),
										  rs.getString("titulo_japones"),
										  rs.getInt("id_anime"),
										  rs.getInt("capitulos"));
				
			}
			
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		
		this.closeConnection();
		return t;
	}

	public void insertar(Temporada t) {
		Connection c=this.openConnection();
		String query="INSERT INTO temporadas VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.setInt(2, t.getNumeroTemporada());
			ps.setString(3, t.getTitulo());
			ps.setString(4, t.getTitulojapones());
			ps.setInt(5, t.getId_anime());
			ps.setInt(6, t.getCapitulos());
			ps.execute();
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}	
		this.closeConnection();
		
	}

	public void modificar(Temporada t) {
		Connection c=this.openConnection();
		String query="UPDATE temporadas SET numero_temporada=?"
												+ ",titulo=?"
												+ ",titulo_japones=?"
												+ ",id_anime=?"
												+ ",capitulos=?"
												+ " WHERE id=?";
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, t.getNumeroTemporada());
			ps.setString(2, t.getTitulo());
			ps.setString(3,t.getTitulojapones());
			ps.setInt(4, t.getId_anime());
			ps.setInt(5, t.getCapitulos());
			ps.setInt(6, t.getId());
			
			ps.execute();
			
			
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
		
	}

	public void borrar(Temporada t) {
		Connection c=this.openConnection();
		String query="DELETE FROM temporadas WHERE id=?";
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.execute();
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
	}
	
	public void borrarTodo() {
		Connection c=this.openConnection();
		String query="DELETE FROM temporadas";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(query);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
