package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@ManyToOne
	private Pais pais;
	@OneToOne
	private Ubicacion ubicacion;
		
	
	//Constructor
	public Ciudad (String nombre, Pais pais, Ubicacion ubicacion) {
		this.nombre = nombre;
		this.pais = pais;
		this.ubicacion = ubicacion;
	}

	public Ciudad () {
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Long getId() {
		return id;
	}

	
}
