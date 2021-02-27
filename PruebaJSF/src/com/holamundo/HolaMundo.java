package com.holamundo;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.event.NamedEvent;
import javax.faces.view.ViewScoped;

@NamedEvent
@ViewScoped
public class HolaMundo implements Serializable {
 
	
	private static final long serialVersionUID = 1L;
	

	private String mensaje = "Hola, este es mi primer mensaje!";
	
	@PostConstruct
	public String getMensaje() {
		return mensaje;
	}
 
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
		
}