package es.pildoras.pruebaannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("comercialExperimentado")
//@Scope("prototype")
public class ComercialExperimentado implements IEmpleados {

	
	//ejecucion de codigo despued de la creacion del bean
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		System.out.println("Ejecutando tras creación de Bean");
	}
	
	//ejecucion de codigo despues del apagado contenedor Sprieng
	@PreDestroy
	public void ejecutaAntesDestruccion() {
		System.out.println("Ejecutando antes de la destruccion");
	}	
	
	
	//3º configurar la dependencia de la inyeccion co @autowired	
	
	@Autowired
	@Qualifier("informeFinancieroTrim3") // bean Id que debe utilizar
	private ICreacionInformeFinanciero nuevoInforme;
	
	public ComercialExperimentado() {
		
	}
	
	
	/*@Autowired
	public ComercialExperimentado(ICreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}*/
	
	
	
	
	public void setNuevoInforme(ICreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}


	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender, vender y vender mas";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		//return "Informe generado por el comercial";
		
		return nuevoInforme.getInformeFinanciero();
	}

}
