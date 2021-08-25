package javaee.amigos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.Logger;

public class AccesoBD {
	
	
    private final static Logger LOGGER = Logger.getLogger(AccesoBD.class); 	
	private static Connection con = null;
	private static String password = "root1234";
	private static String usuario = "root";
	private static String DBUrl = "jdbc:mysql://localhost:3306/dbamigos?user=" + usuario
			+ "&password=" + password + "&useSSL=false";

	// Método público para establecer la cadena de conexion
	public static void setURL(String dburl) {
		DBUrl = dburl;
	}

	/** Devuelve un objeto del tipo Connection con la base de datos */
	public static Connection getConectar()  {
		// Si no existe la conexion entonces se crea
		if (con == null) {
			try {
				// Registamos el driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception e) {
				
				LOGGER.fatal("No se ha encontrado el driver JDBC", e);
				
				//System.out.println("No se ha encontrado el driver JDBC");
			}

			try {
				// Obtenemos la conexion
				con = DriverManager.getConnection(DBUrl);
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());
			}
		}
		// Devolvemos un objeto Connection
		return con;
	}

	/** Desconecta de la base de datos */
	public static void desconecta() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());
			}
		}
	}	
	
	
	
	
	
	
	
	
	
	
/*
public Connection getConectar() {
	Connection con = null;	
	String password = "root1234";
	String usuario = "root";
	String url = "jdbc:mysql://localhost:3306/dbamigos?user=" + usuario
			+ "&password=" + password + "&useSSL=false";
	
	
	try {
		// Registramos el driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	} catch (Exception e) {
		System.out.println("No se ha encontrado el driver JDBC");
	}	
	try {
		con = DriverManager.getConnection(url);
		if (con != null) {
			System.out.println("Conectado");
		}
	} catch (SQLException e) {
		System.out.println("No se pudo conectar a la base de datos");
		e.printStackTrace();
	}
	return con;
}


*/

}
