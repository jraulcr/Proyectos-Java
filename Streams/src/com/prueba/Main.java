package com.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public final static Logger LOG = Logger.getLogger("Main");

	public static void main(String[] args) {
		
		List <Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("1111AAA", Modelo.BMW, 10000));
        vehiculos.add(new Vehiculo("2222BBB", Modelo.AUDI, 20000));
        vehiculos.add(new Vehiculo("3333CCC", Modelo.OPEL, 30000));
        vehiculos.add(new Vehiculo("4444DDD", Modelo.BMW, 100000));
        vehiculos.add(new Vehiculo("5555EEE", Modelo.AUDI, 200000));
        vehiculos.add(new Vehiculo("6666FFF", Modelo.OPEL, 300000));
        vehiculos.add(new Vehiculo("7777GGG", Modelo.CITROEN, 0));
        
        
        
        //https://codingfactsblog.wordpress.com/2017/08/01/jugando-con-streams-y-predicates-en-java/ 
        /**
         * map: Altera los elementos en base a una función y los devuelve alterados. 
         * También permite realizar proyecciones de atributos.
         * 
         * */
    	// Alteración de kilómetros
    	List<Integer> result = vehiculos.stream()
    	        .map(v -> v.getKilometros()*2)
    	        .collect(Collectors.toList());
        
    	LOG.info("Resultado con MAP: " + result + "\r");        
    	
    	// Proyección del campo kilómetros
    	List<Integer> result2 = vehiculos.stream()
    	        .map(Vehiculo::getKilometros)
    	        .collect(Collectors.toList());
    	
    	LOG.info("Resultado con MAP 2: " + result2 + "\r" );
    	

        /**
         * filter:  Filtra los elementos a partir del la condición de la función pasada como parámetro.
         * 
         * */
    	List<Vehiculo> result3 = vehiculos.stream()
    	        .filter(v -> v.getModelo().equals(Modelo.AUDI))
    	        .collect(Collectors.toList());    	
    	
    	result3.forEach(e -> LOG.info("Resultado con FILTER: " 
    			+ e.getModelo() + ", " 
    			+ e.getMatricula()  + ", " 
    			+ e.getKilometros() + "\r" ));  	
    	
    	
	  	/**
	  	 * sorted: Ordena los elementos siguiendo la condición de la función como parámetro.
	  	 * 
	  	 */
    	List<Vehiculo> result4 = vehiculos.stream()
    	        .sorted((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
    	        .collect(Collectors.toList());
    	
    	result4.forEach(e -> LOG.info("Resultado con SORTED:  " 
    				+ e.getModelo() + ", " 
    				+ e.getMatricula()  + ", " 
    				+  e.getKilometros() + "\r" ));
    	
    	/**
    	 * distinct: Retorna un stream con elementos no repetidos basándose en la comparación entre objetos 
    	 * con la función equals (Object.equals(object)).
    	 */
    	
    	// Utilizando equals de Vehiculo
    	 List<Vehiculo> result5 = vehiculos.stream()
    	         .distinct()
    	         .collect(Collectors.toList());
    	
     	result5.forEach(e -> LOG.info("Resultado con DISCTINT:  " 
				+ e.getModelo() + ", " 
				+ e.getMatricula()  + ", " 
				+ e.getKilometros() + "\r" ));
     	
     	
     // Distintos según modelo
     	 List<Modelo> result6 = vehiculos.stream()
     	         .map(Vehiculo::getModelo)
     	         .distinct()
     	         .collect(Collectors.toList());
     	
      	LOG.info("Resultado con DISCTINT 2:  " 
 				+ result6 + "\r" );   	
     	
     	/**peek: Esta operación no realiza cambios sobre el stream y lo devuelve tal y como entra. 
     	 * El propósito principal consiste en hacer debugging al ejecutar cualquier otra operación, 
     	 * ya que permite imprimir valores de los elementos del stream.
     	 * 
     	 */
      	
      	List<String> result7 = vehiculos.stream()
      	        .filter(v -> v.getKilometros() > 20000)
      	        .peek(v -> System.out.println(v))
      	        .map(Vehiculo::getMatricula)
      	        .peek(v -> System.out.println(v))
      	        .collect(Collectors.toList());
      	LOG.info("Resultado con PEEK:  " 
 				+ result7 + "\r" ); 

     	
      	/**
      	 * collect: Ejecuta lo que denominan mutable reduction, que consiste en acumular los resultados en una 
      	 * Collection a medida que los va procesando en la pipeline del stream. 
      	 */
      	List<Vehiculo> vehiculosCollect = vehiculos.parallelStream()
      	        .limit(5)
      	        .collect(Collectors.toList());
      	
      	vehiculosCollect.forEach(e -> LOG.info("Resultado con COLLECT:  " 
				+ e.getModelo() + ", " 
				+ e.getMatricula()  + ", " 
				+ e.getKilometros() + "\r" ));
      	
      	
      	Map<Modelo, List<Vehiculo>> groupByModel = vehiculos.parallelStream()
      	        .collect(Collectors.groupingBy(Vehiculo::getModelo));
      	 
      	groupByModel.forEach((Modelo key, List<Vehiculo> vehiculo) -> LOG.info(key + " -> "+ vehiculo + " \r "));

        
      	
      	
      	//https://medium.com/@yonem9/estudiando-java-avanzado-java-8-qu%C3%A9-narices-es-eso-de-los-stream-c99d665c4ab6
      	
      	ArrayList<Vehiculo> veh = new ArrayList<>(vehiculosCollect);
        System.out.println(veh);

        Stream <Vehiculo> stream = veh.stream();
        stream.forEach(p -> System.out.println(p));
	
	
	}

	
	
	
}
