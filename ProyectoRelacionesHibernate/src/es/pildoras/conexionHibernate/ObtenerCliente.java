package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {

	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();

			
			//Obtener detalles cliente
			
			DetallesCliente detallesDeCliente = miSession.get(DetallesCliente.class, 4);
			
			System.out.println(detallesDeCliente);
			
			System.out.println(detallesDeCliente.getCliente());

			System.out.println("Eliminamos en cascada");			
			miSession.delete(detallesDeCliente);
			
			miSession.getTransaction().commit();

		
			
		}catch(Exception ex1){
			
			ex1.printStackTrace();

		} finally {
			// TODO: handle finally clause
			
			miSession.close();
			miFactory.close();
		}
	}

}
