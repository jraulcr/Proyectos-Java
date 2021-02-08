package es.pildoras.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub		

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			//Comenzar sesion
			miSession.beginTransaction();
			
			//Consultar clientes
			List<Cliente> losClientes = miSession.createQuery("FROM Cliente").getResultList();
			
			recorreClientesConsultado(losClientes);
			
			//Consulta dame todos los Crespo			
			losClientes = miSession.createQuery("FROM Cliente c WHERE c.apellidos = 'Crespo'").getResultList();
			
			recorreClientesConsultado(losClientes);
			
			//Muestran los que viven en Cuenca y se apellidan Pijo
			losClientes = miSession.createQuery("FROM Cliente c WHERE c.apellidos = 'Pijo'" + 
			"OR c.direccion = 'Cuenca'").getResultList();
			
			
			recorreClientesConsultado(losClientes);

			
			//commit		
			miSession.getTransaction().commit();
			//Cierre
			miFactory.close();
			
		} finally {
			miFactory.close();
		}

	}

	private static void recorreClientesConsultado(List<Cliente> losClientes) {
		for (Cliente unCliente : losClientes) {
			System.out.println(unCliente);
		}
	}

}
