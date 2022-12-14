package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que nos abre la conexion con la base de datos de animes
 * @author Francisco Jose Jimenez Diaz
 *
 */
public class ConexionBD {
	private static Connection conexion;
	
	/**
	 * Metodo que crea una conexion y nos la devuelve para acceder a la BBDD
	 * @return Connection que nos permite acceder a la base de datos.
	 */
	public Connection getConnection(){
		String namebd="bdanimes";
		String user="root";
		String pass="root";
		
			try {
				conexion=DriverManager.getConnection("jdbc:mysql://localhost/"+namebd,user,pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return conexion;
	}
	
	/**
	 * Metodo que cierra la conexion con la base de datos
	 */
	public void closeConnection() {
		if(conexion!=null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
