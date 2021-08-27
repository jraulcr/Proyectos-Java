package com.prueba.empleados;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BColecciones {

	public static void main(String[] args) {

		List<Empleado> empleados = Arrays.asList(
				new Empleado("Pepe", 30000, "Ventas"),
				new Empleado("Pepe", 30000, "Ventas"),
				new Empleado("Juan", 31000, "Ventas"),
				new Empleado("Antonio", 30000, "Compras"),
				new Empleado("María", 30000, "Compras"),
				new Empleado("Manuela", 34000, "Ejecutiva")
				);
		
		Set<Empleado> setEmpleados = empleados.stream().collect(Collectors.toSet());
		System.out.println("Listado con SET: " + setEmpleados);
		
		List<Empleado> listEmpleados = empleados.stream().collect(Collectors.toList());
		System.out.println("Listado con LIST: " + listEmpleados);
		
		Map<String, Double> mapEmpleados = empleados.stream().distinct()
				.collect(Collectors.toMap(Empleado::getNombre, Empleado::getSalario));
		System.out.println("Listado con MAP: " + mapEmpleados);
				

		mapEmpleados.forEach((key, value) -> System.out.println("Listado con MAP 2: " + key + " = " + value));
	}

}
