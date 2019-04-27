package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Sucursal {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String calle;
	private Integer numero;
	
	@ManyToOne
//	@Cascade(value = CascadeType.ALL)
	private Empresa empresa;
	
	
	public Sucursal(String calle, Integer numero, Empresa empresa) {
		this.calle = calle;
		this.numero = numero;
		this.empresa = empresa;
	}
	
	//Getters and Setters.
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
