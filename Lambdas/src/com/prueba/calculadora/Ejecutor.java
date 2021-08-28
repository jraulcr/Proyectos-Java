package com.prueba.calculadora;

public class Ejecutor {

	
	public void calcular(double num1, double num2) { 
		
		ICalculadora suma = (n1, n2) -> n1 + n2;
		ICalculadora resta = (n1, n2) -> n1 - n2;
		ICalculadora multiplicacion = (n1, n2) -> n1 * n2;
		ICalculadora division = (n1, n2) -> n1 / n2;
		ICalculadora resto = (n1, n2) -> n1 % n2;
		
		System.out.println("La suma es: " + suma.operacion(num1, num2));
		System.out.println("La resta es: " + resta.operacion(num1, num2));
		System.out.println("La multiplicacion es: " + multiplicacion.operacion(num1, num2));
		System.out.println("La division es: " + division.operacion(num1, num2));
		System.out.println("La resto es: " + resto.operacion(num1, num2));
		
	}
	
	public static void main(String[] args) {
		
		//System.out.println("Hola mundo");
		//ICalculadora calculadora = (n) -> System.out.println(n + "Hola mundo");		
		//calculadora.mensaje("Raul ");
		
/*		ICalculadora calculadora = (n1, n2) -> {
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

		calculadora.operacion(2, 3);*/
		
		
		Ejecutor resultado = new Ejecutor();
		resultado.calcular(2, 3);
	}

}
