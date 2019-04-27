package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Central {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String calle;
	
	@OneToOne
//	@Cascade(value = CascadeType.ALL )
	private Sucursal sucursal;
	
	public Central(String nombre, String calle, Sucursal sucursal) {
		this.nombre = nombre;
		this.calle = calle;
		this.sucursal = sucursal;
	}
	
	



	//Getters and Setters.
	public Long getId() {
		return id;
	}
	
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	
}