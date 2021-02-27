package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();

			DetallesCliente detalleDelCliente = miSession.get(DetallesCliente.class, 36);
			
			detalleDelCliente.getCliente().setDetallesCliente(null);
			
			if (detalleDelCliente != null) {
				//System.out.println("Voy a liminar el cliente: " + detalleDelCliente.getNombre());
				miSession.delete(detalleDelCliente);
			}

			miSession.getTransaction().commit();

			if (detalleDelCliente != null) {
				System.out.println("Registro eliminado correctamente en BB.DD.");				
			} else {
				System.out.println("Nada que eliminar");
			}

			miSession.close();

		} finally {
			// TODO: handle finally clause
			miFactory.close();
		}
	}
}
