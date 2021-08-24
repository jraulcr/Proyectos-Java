package com.prueba;

interface ITelevisorLambdaPrueba { 
	int volumen (String modo, int valor);  
}

public class TelevisorLambdaPrueba {

	private static int vol;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ITelevisorLambdaPrueba televisorSony = (modo, valor) -> 
			 modo.equals("subir") ? (vol += valor) : (vol -= valor);
				
		int res = televisorSony.volumen("bajar", 1);
		
		System.out.println("Volumen ********: " + res);
		

	}
}