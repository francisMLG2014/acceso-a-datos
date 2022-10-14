package proyecto.animales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
public static Connection connection;

	public Connection getConnection(){
		String namebd="bdzoologico";
		String user="root";
		String pass="root";
		if(connection==null) {
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost/"+namebd,user,pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
