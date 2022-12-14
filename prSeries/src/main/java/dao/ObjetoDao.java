package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.ConnectionBD;

public class ObjetoDao {
	private  Connection connection;
	
	protected  Connection openConnection() {
		ConnectionBD dbconnection=new ConnectionBD();
		connection = dbconnection.getConnection();
		return connection;
	}
	
	protected  void closeConnection() {
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
