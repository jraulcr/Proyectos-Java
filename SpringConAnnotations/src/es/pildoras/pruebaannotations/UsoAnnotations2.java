package es.pildoras.pruebaannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1º leer el xml de configuracion
	//	ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//leer el class de configuracion		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(EmpleadosConfig.class);
		
		
		//2º pedir un bean al contenedor
		
		
		DirectorFinanciero empleado = contexto.getBean("directorFinanciero", DirectorFinanciero.class);
		
		System.out.println("Email del director: " + empleado.getEmail());
		
		System.out.println("Nombre empresa: " + empleado.getNombreEmpresa());

		
		
		
//		IEmpleados empleado = contexto.getBean("directorFinanciero", IEmpleados.class);
//		
//		System.out.println(empleado.getTareas());
//		System.out.println(empleado.getInforme());
		
//		IEmpleados Antonio = contexto.getBean("comercialExperimentado", IEmpleados.class);
//		
//		IEmpleados Lucia = contexto.getBean("comercialExperimentado", IEmpleados.class);

//		//¿Apuntan al mismo objeto de memoria?	
//		if (Antonio.equals(Lucia)) {
//			System.out.println("Apuntan a la misma memoria");
//			System.out.println(Antonio + "\n" + Lucia);
//		} else {
//			System.out.println("NO Apuntan a la misma memoria");
//			System.out.println(Antonio + "\n" + Lucia);
//		}
		
		//4º cerrar el contexto		
		contexto.close();

	}

}
