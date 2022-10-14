package proyecto.animales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeConnection();
		}
		
	}
	
	public static void deleteAnimal() {
		
	}
	
	
	
	
	private static Connection openConnection() {
		ConnectionBD dbconnection=new ConnectionBD();
		connection = dbconnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		try {
			connection.close();
			connection=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
}
