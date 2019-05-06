package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;

@Entity
public class Continente {
	private Long id;
	private String nombre;
	
	
	// Constructor
	public Continente (String nombre) {
		this.nombre = nombre;
	}

	
	//Getters y Setters
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
