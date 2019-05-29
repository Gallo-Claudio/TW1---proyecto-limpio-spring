package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoPersonasDao;
import ar.edu.unlam.tallerweb1.modelo.Persona;


@Service("servicioListarPersonas")
@Transactional
public class ServicioListarPersonasImpl implements ServicioListarPersonas {

	@Inject
	private ListadoPersonasDao servicioListadoPersonasDao;

	@Override
	public List<Persona> listarPersonas () {
		// Llamo al metodo "listaPersonas()" de la instancia del objeto "servicioListadoPersonasDao", que esta en el area del DAO
		// El valor obtenido es retornado
		return servicioListadoPersonasDao.listaPersonas();
	}

}
