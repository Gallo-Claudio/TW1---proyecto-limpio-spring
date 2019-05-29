package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("ingresoUsuarioDao")
public class IngresoUsuarioDaoImpl implements IngresoUsuarioDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void ingresarUsuario (Persona persona) {  

		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		session.save(persona);    // Persisto en la BD, el objeto recibido desde el area de Servicios

	}

}
