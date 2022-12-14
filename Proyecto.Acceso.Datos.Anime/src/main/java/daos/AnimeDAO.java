package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InterfazDAO;
import pojos.Anime;

public class AnimeDAO extends ObjetoDAO implements InterfazDAO<Anime>{

	public ArrayList<Anime> buscarTodos() {
		ArrayList<Anime> animes=new ArrayList<Anime>();
		Connection c=this.openConnection();
		try {
			String query="SELECT * FROM animes";
			PreparedStatement ps=c.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Anime a=new Anime(rs.getInt("id"),
								  rs.getString("titulo"),
								  rs.getString("titulo_japones"),
								  rs.getBoolean("en_emision"));
				animes.add(a);
			}
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
		
		return animes;
	}

	public Anime buscarPorId(int i) {
		Anime a=null;
		Connection c=this.openConnection();
		String query="SELECT * FROM animes WHERE id=?";
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				a=new Anime(rs.getInt("id"),
						    rs.getString("titulo"),
						    rs.getString("titulo_japones"),
						    rs.getBoolean("en_emision"));
				
			}
			
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		
		this.closeConnection();
		return a;
	}

	public void insertar(Anime t) {
		Connection c=this.openConnection();
		String query="INSERT INTO animes VALUES(?,?,?,?)";
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getTitulo());
			ps.setString(3, t.getTitulojapones());
			ps.setBoolean(4, t.isEnEmision());
			
			ps.execute();
			
			
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
		
	}

	public void modificar(Anime t) {
		Connection c=this.openConnection();
		String query="UPDATE animes SET "
								+ "titulo=?,"
								+ "titulo_japones=?,"
								+ "en_emision=?"
								+ " WHERE id=?";
		
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, t.getTitulo());
			ps.setString(2, t.getTitulojapones());
			ps.setBoolean(3, t.isEnEmision());
			ps.setInt(4, t.getId());
			
			ps.execute();
			
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
		
	}

	public void borrar(Anime t) {
		Connection c=this.openConnection();
		String query="DELETE FROM animes WHERE id=?";
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
		String query="DELETE FROM animes";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(query);
			ps.execute();
			
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
		
	}
	
	/**
	 * @param t Anime del cual queremos saber la cantidad de temporadas que tiene guardadas en la base de datos
	 * @return Cantidad de temporadas que tiene registrada en la base de datos
	 */
	public int cantidadTemporadas(Anime t) {
		int temporadas=0;
		Connection c=this.openConnection();
		String query="SELECT COUNT(id) AS 'cantidad' FROM temporadas WHERE id_anime=?";
		try {
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, t.getId());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				temporadas=rs.getInt("cantidad");
			}
			
		} catch (SQLException e) {
			this.closeConnection();
			e.printStackTrace();
		}
		this.closeConnection();
		return temporadas;
	}


}
