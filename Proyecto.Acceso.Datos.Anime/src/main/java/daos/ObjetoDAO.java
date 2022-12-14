package daos;

import java.sql.Connection;
import java.sql.SQLException;

import bbdd.ConexionBD;

public abstract class ObjetoDAO {
	
		
		private static Connection connection;

		protected Connection openConnection() {
			ConexionBD dbConnection = new ConexionBD();
			connection = dbConnection.getConnection();
			return connection;
		}
		
		protected void closeConnection() {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
