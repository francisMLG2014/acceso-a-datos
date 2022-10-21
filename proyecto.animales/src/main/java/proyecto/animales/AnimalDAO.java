package proyecto.animales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AnimalDAO {
	
	private static Connection connection;
	
	public static void insertAnimal(Animal animal) {
		connection=openConnection();
		String query="insert into animales (nombre,habitat,peso_aproximado) values(?,?,?);";
		try {
			PreparedStatement pe=connection.prepareStatement(query);
			pe.setString(1, animal.getNombre());
			pe.setString(2, animal.getHabitat());
			pe.setDouble(3, animal.getPeso_aproximado());
			pe.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection();
		}
		closeConnection();
	}
	
	public static void deleteAnimalByNombre(String nombre) {
		connection=openConnection();
		String query="delete from animales where nombre = ? ";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.executeUpdate();
		} catch (SQLException e) {
			closeConnection();
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public static ArrayList<Animal> findAllAnimals(){
		
		ArrayList<Animal> animales=new ArrayList<Animal>();
		connection=openConnection();
		String query="select * from animales";
		
		PreparedStatement ps=null;
		try {
			ps = connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				 Animal animal=new Animal(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("habitat"),
						rs.getDouble("peso_aproximado")
						);
				 animales.add(animal);
			}
			
			
			
		} catch (SQLException e) {
			closeConnection();
			e.printStackTrace();
		}
		closeConnection();
		return animales;
		
		
	}
	
	
	
	
	
	public static Animal findByID(int id) {
		connection=openConnection();
		
		String query ="select * from animales wuere id = ?";
		Animal animal=null;
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 animal=new Animal(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("habitat"),
						rs.getDouble("peso_aproximado")
						);
			}
			
			
			
		} catch (SQLException e) {
			closeConnection();
			e.printStackTrace();
		}
		closeConnection();
		return animal;
		
		
		
	}
	
	
	public static void deleteAllAnimals() {
		connection=openConnection();
		
		String query="delete from animales";
		
		Statement statement=null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
