/**
 * 
 */
package es.pildoras.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mabera
 *
 */
public class UsoEmpleados {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//1. Cargar el XML "applicationContext.xml"
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. Pedir el Bean
		Empleados Juan = contexto.getBean("miEmpleado", Empleados.class);
		//3. Utilizar el Bean
		System.out.println(Juan.getTareas());
		//4. Cerrar el XML
		contexto.close();

		// Creación de objetos del tipo Empleado

		/*Empleados Empleado1 = new DirectorEmpleado();

		// Uso de los objetos creados

		System.out.println(Empleado1.getTareas());*/
	}

}
