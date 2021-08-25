 package com.prueba;

public class CalculadoraFortuna {

	public static void main (String args[]) {

		ICalculadoraFortuna icf = (nombre) -> nombre.length();
		
		int miSuerte = icf.calcularSuerte("Pepe Pijo");
		System.out.println(miSuerte);
		
	}

}
