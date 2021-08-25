package com.prueba;

public class TelevisorLambda {

	private static int vol;

	public static void main(String[] args) {

		ITelevisorLambda televisorSony = (modo, valor) -> {
			int res = modo.equals("subir") ? (vol += valor) : (vol -= valor);
			System.out.println("Volumen ********: " + res);
		};

		televisorSony.volumen("bajar", 1);

	}

}
