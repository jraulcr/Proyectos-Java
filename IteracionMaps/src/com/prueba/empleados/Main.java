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
		 * El m�todo keySet() se usa para recoger 
		 * un conjunto de claves de Map que luego se usa para iterar usando un bucle for-each./
		 */
		
		for (String key : map.keySet()) {
		     System.out.println(key +" : "+map.get(key));
		}

		/**
		 * Aqu�, usamos el m�todo iterator() para obtener el iterador de claves 
		 * y luego iterar estas claves usando el bucle while. Para obtener el valor de una clave, usamos el m�todo get().*/
		
		Iterator<String> itr = map.keySet().iterator();
		while (itr.hasNext()) {
		    String key = itr.next();
		    System.out.println(key +" : "+map.get(key));
		}
		
		
		/**
		 * Podemos usar la corriente para iterar los elementos. Aqu�, usamos entrySet() 
		 * para recoger las entradas del mapa que se desplazaron a trav�s del m�todo forEach().
		 * */
		
		map.entrySet()
		.stream()
		.forEach(System.out::println);
		
		/**
		 * Tambi�n podemos usar la expresi�n lambda para iterar los elementos del mapa. 
		 * Aqu�, usamos la expresi�n lambda dentro del m�todo forEach().
		 * */
		map.forEach((key, value) -> System.out.println(key + " : " + value));
		
	}

}
