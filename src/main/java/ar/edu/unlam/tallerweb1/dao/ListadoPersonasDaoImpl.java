package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("listadoPersonasDao")
public class ListadoPersonasDaoImpl implements ListadoPersonasDao {

	@Inject
    private SessionFactory sessionFactory;
	List <Persona> listadoDePersonas;
	
	@Override
	public List<Persona> listaPersonas () {
		final Session session = sessionFactory.getCurrentSession(); // Obtengo una sesion
		// A traves de la sesion abierta, consulto en la tabla Personas que esta en la BD
		// y guardo el valor obtenido en la coleccion del tipo List llamada "listadoDePersonas
		// para luego retornar el resultado
		listadoDePersonas = session.createCriteria(Persona.class).list();
		return (listadoDePersonas);
	}

}
