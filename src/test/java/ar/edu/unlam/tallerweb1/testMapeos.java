package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.*;


public class testMapeos extends SpringTest {

	@Test
	@Transactional
	@Rollback (true)
	public void test() {
		Empresa empresa1 = new Empresa();
		empresa1.setNombre("Diamante");
		getSession().save(empresa1);
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Rubi");
	//	getSession().save(empresa2);
		
		
		Sucursal sucursal1 = new Sucursal("Arroyo", 897, empresa1);
		Sucursal sucursal2 = new Sucursal("Salguero", 1542, empresa1);
		getSession().save(sucursal1);
		getSession().save(sucursal2);
		
		
		Central central1 = new Central("Antena Norte", "Cordoba", sucursal1);
		Central central2 = new Central("Pampa Antena", "9 de Julio", sucursal2);
		getSession().save(central1);
		getSession().save(central2);
		
		
		Llamada llamada1 = new Llamada(30,central1);
		Llamada llamada2 = new Llamada(45,central1);
		Llamada llamada3 = new Llamada(10,central2);
		Llamada llamada4 = new Llamada(25,central2);
		getSession().save(llamada1);
		getSession().save(llamada2);
		getSession().save(llamada3);
		getSession().save(llamada4);
		
		
		Empresa controlNombre = getSession().get(Empresa.class, llamada3.getCentral().getSucursal().getEmpresa().getId());
		
		
		
		assertThat(controlNombre).isNotNull();
		assertThat(empresa1.getNombre()).isSameAs(controlNombre.getNombre());
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@Test
	@Transactional
	@Rollback (true)
	public void test1(){
		Empresa empresa1 = new Empresa();
		empresa1.setNombre("Diamante");
		getSession().save(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Rubi");
		getSession().save(empresa2);
		
		Sucursal sucursal1 = new Sucursal("Avellaneda", 25, empresa1);
		getSession().save(sucursal1);
		
		Sucursal sucursal2 = new Sucursal("Pekin", 50, empresa1);
		getSession().save(sucursal2);
		
		Sucursal sucursal3 = new Sucursal("Rivadavia", 75, empresa2);
		getSession().save(sucursal3);
		
		// TODAS LAS SUCURSALES QUE TENGAN LA EMPRESA 1 ("DIAMANTE")
		List<Sucursal> sucursalesQueCumplenCondicion = getSession()
				.createCriteria(Sucursal.class)
				.add(Restrictions.eq("empresa", empresa1))
				.list();
		
		Integer valorEsperado = 2;
		Integer valorObtenido = sucursalesQueCumplenCondicion.size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
	@Transactional
	@Rollback (true)
	public void test2(){
		Empresa empresa1 = new Empresa();
		empresa1.setNombre("Diamante");
		getSession().save(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Rubi");
		getSession().save(empresa2);
		
		Sucursal sucursal1 = new Sucursal("Avellaneda", 25, empresa1);
		getSession().save(sucursal1);
		
		Sucursal sucursal2 = new Sucursal("Pekin", 50, empresa1);
		getSession().save(sucursal2);
		
		Sucursal sucursal3 = new Sucursal("Rivadavia", 75, empresa2);
		getSession().save(sucursal3);
		
		// TODAS LAS SUCURSALES CON EMPRESAS CUYO NOMBRE COMIENCE CON "D".
		List<Sucursal> sucursalesQueCumplenCondicion2 = getSession()
				.createCriteria(Sucursal.class)
				.createAlias("empresa", "empresaBuscada")
				.add(Restrictions.like("empresaBuscada.nombre", "D%"))
				.list();
		
		Integer valorEsperado = 2;
		Integer valorObtenido = sucursalesQueCumplenCondicion2.size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	/* TODAS LAS LLAMADAS CON DURACION > 2 QUE SEAN DE LA CENTRAL CON CALLE "FLORENCIO VARELA" 
	   QUE SEAN DE LA EMPRESA "TELEFÓNICA" */

	
	@Test
	@Transactional
	@Rollback (true)
	public void testQueFiltraLlamadas(){
		Empresa empresa1 = new Empresa();
		empresa1.setNombre("Diamante");
		getSession().save(empresa1);
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Rubi");
		getSession().save(empresa2);
		
		
		Sucursal sucursal1 = new Sucursal("Arroyo", 897, empresa1);
		Sucursal sucursal2 = new Sucursal("Salguero", 1542, empresa1);
		getSession().save(sucursal1);
		getSession().save(sucursal2);
		
		
		Central central1 = new Central("Antena Norte", "Cordoba 1345", sucursal1);
		Central central2 = new Central("Pampa Antena", "Darragueira 687", sucursal2);
		getSession().save(central1);
		getSession().save(central2);
		
		
		Llamada llamada1 = new Llamada(30,central1);
		Llamada llamada2 = new Llamada(45,central1);
		Llamada llamada3 = new Llamada(10,central2);
		Llamada llamada4 = new Llamada(25,central2);
		Llamada llamada5 = new Llamada(10,central1);
		getSession().save(llamada1);
		getSession().save(llamada2);
		getSession().save(llamada3);
		getSession().save(llamada4);
		getSession().save(llamada5);
		

		List <Llamada> registroLlamadas = getSession().createCriteria(Llamada.class)
			.add(Restrictions.gt("duracion",20))
				
			.createAlias("central", "buscaCentral")
			.add(Restrictions.eq("buscaCentral.calle","Cordoba 1345"))
			
	    	.createAlias("central.sucursal", "buscaSucursal")

			
			.createAlias("central.sucursal.empresa", "buscaEmpresa")
			.add(Restrictions.eq("buscaEmpresa.nombre", "Diamante"))
			
			.list();
		
		Integer valorEsperado = 2;
		Integer valorObtenido = registroLlamadas.size();
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	
}
