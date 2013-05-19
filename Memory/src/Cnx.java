
/**
 * @(#)ConexionDB.java
 *
 *
 * @author
 * @Jose Caceres Guzman 
 * @version 1.00 2010/1/8
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Cnx {

	public Connection getConexion()
	{
		Connection res = null;
		String driver = "org.postgresql.Driver";
		String connectString = "jdbc:postgresql://localhost:5432/Agiles";
		String user = "postgres";
		String password = "postgres123";

		try{
		Class.forName(driver);
		res = DriverManager.getConnection(connectString, user , password);
	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return res ;
	}
}
