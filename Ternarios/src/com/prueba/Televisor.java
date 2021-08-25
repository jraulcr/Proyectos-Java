package com.prueba;

public class Televisor {

	private int volumen;
	
	public int subirVolumen(String modo, int valor) {		
		return volumen = modo.equals("subir") ? (volumen += valor) : (volumen -= valor); 		
	}

}