package es.pildoras.pruebaannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		//1º leer el xml de configuracion
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2º pedir un bean al contenedor
		IEmpleados Antonio = contexto.getBean("comercialExperimentado", IEmpleados.class);
		
		
		//3º usar el bean
		System.out.println(Antonio.getTareas());
		
		System.out.println(Antonio.getInforme());
		
		//4º cerrar el contexto		
		contexto.close();
	}

}
