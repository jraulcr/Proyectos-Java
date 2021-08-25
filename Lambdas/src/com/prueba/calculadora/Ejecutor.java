package com.prueba.calculadora;

public class Ejecutor {

	public static void main(String[] args) {
		
		//System.out.println("Hola mundo");
		//ICalculadora calculadora = (n) -> System.out.println(n + "Hola mundo");		
		//calculadora.mensaje("Raul ");
		
		ICalculadora calculadora = (n1, n2) -> {
			double suma = n1 + n2;
			System.out.println("La suma es: " + suma);
			double resta = n1 - n2;
			System.out.println("La resta es: " + resta);
			double multiplicacion = n1 * n2;
			System.out.println("La resta es: " + multiplicacion);
			double division = n1 / n2;
			System.out.println("La resta es: " + division);
			double resto = n1 % n2;
			System.out.println("La resta es: " + resto);
		};

		calculadora.operacion(2, 3);
	}

}
