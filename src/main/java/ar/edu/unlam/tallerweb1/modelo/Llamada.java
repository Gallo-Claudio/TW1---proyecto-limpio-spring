package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Llamada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer duracion;
	
	@ManyToOne
//	@Cascade(value = CascadeType.ALL)
	private Central central;
	
	
	public Llamada (Integer duracion, Central central) {
		this.duracion = duracion;
		this.central = central;
	}
	
	
	//Getters and Setters.
	public Long getId() {
		return id;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Central getCentral() {
		return central;
	}

	public void setCentral(Central central) {
		this.central = central;
	}
}
