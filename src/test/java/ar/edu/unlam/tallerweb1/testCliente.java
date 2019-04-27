package ar.edu.unlam.tallerweb1;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import static org.assertj.core.api.Assertions.*;

public class testCliente extends SpringTest{
	
	@Test
	@Transactional
	@Rollback (true)
	public void testQueInsertaUnCliente(){
		Cliente cliente1 = new Cliente();
		cliente1.setName("Ricardo");// EL ID NO SE ESCRIBE PORQUE SE AUTOGENERA
		getSession().save(cliente1); // LO GUARDA EN LA BASE DE DATOS (TABLA CLIENTE)
		
		// CREAMOS UN NUEVO OBJETO PARA PODER COMPARAR LOS DATOS
		// SE COMPARA POR ID
		Cliente clienteDeTabla = getSession().get(Cliente.class, cliente1.getId());
		
		assertThat(clienteDeTabla).isNotNull();
		assertThat(cliente1.getName()).isSameAs(clienteDeTabla.getName());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testQueActualizaUnCliente(){
		Cliente cliente = new Cliente();
		cliente.setName("Ricardoo");
		getSession().save(cliente);
		
		Cliente clienteObtenido = getSession().get(Cliente.class, cliente.getId());
		
		clienteObtenido.setName("Ricardo");
		
		getSession().update(clienteObtenido);
		
		Cliente clienteObtenidoModificado = getSession().get(Cliente.class, clienteObtenido.getId());
		
		assertThat(clienteObtenido.getName()).isEqualTo(clienteObtenidoModificado.getName());
		
	}
}
