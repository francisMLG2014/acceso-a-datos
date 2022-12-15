package daos;

import java.sql.Connection;
import java.sql.SQLException;

import bbdd.ConexionBD;
/**
 * Clase que contiene los metodos necesarios para crear conexiones con la base de datos.
 * @author Francisco Jose
 *
 */
public abstract class ObjetoDAO {
	
		/**
		 * Variable que usaremos para almacenar la conexion de la base de datos.
		 */
		private static Connection connection;

		/**
		 * Metodo que abre una conexion con la base de datos.
		 * @return Connection con la conexion a la base de datos.
		 */
		protected Connection openConnection() {
			ConexionBD dbConnection = new ConexionBD();
			connection = dbConnection.getConnection();
			return connection;
		}
		
		/**
		 * Metodo que cierra la conexion de la base de datos.
		 */
		protected void closeConnection() {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
