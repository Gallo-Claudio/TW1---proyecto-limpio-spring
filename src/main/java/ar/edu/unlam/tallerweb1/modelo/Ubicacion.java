package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;

@Entity
public class Ubicacion {
	private Long id;
	private Double latitud;
	private Double longitud;
	
	
	//Constructor
	public Ubicacion(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	
	//Getters y Setters
	public Double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	
	public Double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
	public Long getId() {
		return id;
	}
	
}
