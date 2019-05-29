package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.IngresoUsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Persona;


@Service("servicioIngresoUsuario")
@Transactional
public class ServicioIngresoUsuarioImpl implements ServicioIngresoUsuario {

	@Inject
	private IngresoUsuarioDao servicioIngresoUsuarioDao;

	@Override
	public void ingresarUsuario (Persona persona) {  	
		servicioIngresoUsuarioDao.ingresarUsuario(persona);  //Paso el objeto persona que recibo del Controller hacia el DAO
	}

}
