package com.prueba;

public class TelevisorLambda implements ITelevisorLambda {

	private static int vol;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ITelevisorLambda televisorSony = (modo, valor) -> 
		 modo.equals("subir") ? (vol += valor) : (vol -= valor);
			
		int res = televisorSony.volumen("bajar", 1);
		
		System.out.println("Volumen ********: " + res);
	
		}

	@Override
	public int volumen(String modo, int valor) {
		// TODO Auto-generated method stub
		return 0;
	}
}
