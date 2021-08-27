package com.prueba.empleados;

import java.util.Arrays;
import java.util.List;

public class Mapeo {
	
	public List <Empleado> mapeando () {
	List<Empleado> empleados = Arrays.asList(
			new Empleado("Pepe", 30000, "Ventas"),
			new Empleado("Pepe", 30000, "Ventas"),
			new Empleado("Juan", 31000, "Ventas"),
			new Empleado("Antonio", 30000, "Compras"),
			new Empleado("María", 30000, "Compras"),
			new Empleado("Manuela", 34000, "Ejecutiva")
			);
	
	return empleados;
	}

}
