package com.prueba;

public class CalculadoraFortuna implements ICalculadoraFortuna {

	public static void main (String args[]) {

		ICalculadoraFortuna icf = (nombre) -> nombre.length();
		
		int miSuerte = icf.calcularSuerte("Pepe Pijo");
		System.out.println(miSuerte);
		
	}

	@Override
	public int calcularSuerte(String nombre) {
		// TODO Auto-generated method stub
		return 0;
	}

}
