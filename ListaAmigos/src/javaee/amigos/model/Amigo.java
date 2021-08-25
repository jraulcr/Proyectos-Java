package javaee.amigos.model;

import java.io.Serializable;

public class Amigo implements Serializable {
	
	private static final long serialVersionUID = 4960045619400793497L;

	private int id;
	private String nombre;
	private String telefono;
	private String direccion;
	private String comentarios;
	private int edad;
	private int nivelAmistad;

	public Amigo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNivelAmistad() {
		return nivelAmistad;
	}

	public void setNivelAmistad(int nivelAmistad) {
		this.nivelAmistad = nivelAmistad;
	}

}
