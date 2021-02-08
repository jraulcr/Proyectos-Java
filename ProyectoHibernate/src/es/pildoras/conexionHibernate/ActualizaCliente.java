package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();

		try {
			
		//	int clienteId = 1;
			
			miSession.beginTransaction();
			
		//	Cliente miCliente = miSession.get(Cliente.class, clienteId);
			
		//	miCliente.setNombre("Raúl");
			
			miSession.createQuery("UPDATE Cliente SET Apellidos='Ruiz' WHERE Apellidos LIKE 'C%'").executeUpdate();	

			miSession.getTransaction().commit();
			
			System.out.println("Registro actualizado correctamente en BB.DD.");			

			miSession.close();
			
		} finally {
			// TODO: handle finally clause
			miFactory.close();
		}

	}

}
