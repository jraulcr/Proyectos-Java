package com.prueba;

public class MainTelevisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Televisor televisorSony = new Televisor();
		int res = televisorSony.subirVolumen("bajar", 1);
		System.out.println("Volumen ********: " + res);
	}

}
