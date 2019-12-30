package es.pildoras.pruebaannotations;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim1 implements ICreacionInformeFinanciero {

	//2º creacon de la inyección en la clase que lo solicita
	
	
	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion del informe financiero del trimestre 1";
	}

}
