package es.pildoras.pruebasHibernate;

import java.sql.DriverManager;
import java.sql.Connection;

public class PruebasJDBC {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/relacionesHibernate?useSSL=false";
		String usuario = "root";
		String contra = "root1234";

		try {

			System.out.println("Intentando conectar con la BB.DD." + jdbcUrl);
			Connection miConexion = DriverManager.getConnection(jdbcUrl, usuario, contra);
			System.out.println("Conexión exitosa");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
