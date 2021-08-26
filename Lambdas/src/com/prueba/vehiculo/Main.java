package com.prueba.vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
	
	final static Logger LOG = Logger.getLogger("Main");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("1111AAA", Modelo.BMW, 10000));
        vehiculos.add(new Vehiculo("2222BBB", Modelo.AUDI, 20000));
        vehiculos.add(new Vehiculo("3333CCC", Modelo.OPEL, 30000));
        vehiculos.add(new Vehiculo("4444DDD", Modelo.BMW, 100000));
        vehiculos.add(new Vehiculo("5555EEE", Modelo.AUDI, 200000));
        vehiculos.add(new Vehiculo("6666FFF", Modelo.OPEL, 300000));
        vehiculos.add(new Vehiculo("7777GGG", Modelo.CITROEN, 0));
        
        vehiculos.sort((p1, p2) -> p1.getKilometros() - p2.getKilometros());

       // vehiculos.sort((p1, p2) -> p1.getKilometros() > p2.getKilometros() ? 1 : -1);
                
        Stream <Vehiculo> stream = vehiculos.stream();
        stream.forEach(p -> System.out.println(p.getKilometros() + ", " + p.getModelo() + ", " + p.getMatricula()));
        
	/*	for (Vehiculo p : vehiculos) {

			System.out.println(p.getKilometros() + ", " + p.getModelo() + ", " + p.getMatricula());

		}*/
	
	
	}
}
