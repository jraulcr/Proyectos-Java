package com.prueba.empleados;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Mapeo mapeo = new Mapeo();
	//	System.out.println(x.mapeando());
		
		Map<String, Integer> map = new HashMap<>();
		for (Empleado emp : mapeo.mapeando()) {
			map.put(emp.getNombre(), (int) emp.getSalario());		
		}
		
		System.out.println(map);
		
		/**
		 * El método keySet() se usa para recoger 
		 * un conjunto de claves de Map que luego se usa para iterar usando un bucle for-each./
		 */
		
		for (String key : map.keySet()) {
		     System.out.println(key +" : "+map.get(key));
		}

		/**
		 * Aquí, usamos el método iterator() para obtener el iterador de claves 
		 * y luego iterar estas claves usando el bucle while. Para obtener el valor de una clave, usamos el método get().*/
		
		Iterator<String> itr = map.keySet().iterator();
		while (itr.hasNext()) {
		    String key = itr.next();
		    System.out.println(key +" : "+map.get(key));
		}
		
		
		/**
		 * Podemos usar la corriente para iterar los elementos. Aquí, usamos entrySet() 
		 * para recoger las entradas del mapa que se desplazaron a través del método forEach().
		 * */
		
		map.entrySet()
		.stream()
		.forEach(System.out::println);
		
		/**
		 * También podemos usar la expresión lambda para iterar los elementos del mapa. 
		 * Aquí, usamos la expresión lambda dentro del método forEach().
		 * */
		map.forEach((key, value) -> System.out.println(key + " : " + value));
		
	}

}
