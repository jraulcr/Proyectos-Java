package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BorrarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			
			miSession.beginTransaction();
			
			miSession.createQuery("DELETE Cliente WHERE Direccion = 'Cuenca'").executeUpdate();	

			miSession.getTransaction().commit();
			
			System.out.println("Registro borrado correctamente en BB.DD.");			

			miSession.close();
			
			
		} finally {
			// TODO: handle finally clause
			miFactory.close();
		}

	}

}
