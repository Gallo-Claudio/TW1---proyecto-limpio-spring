package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class testCiudadPaisContinente extends SpringTest {
	
	Continente continente1;
	Continente continente2;
	Continente continente3;
	Continente continente4;
	Continente continente5;
	
	Ubicacion coordenadas1;
	Ubicacion coordenadas2;
	Ubicacion coordenadas3;
	Ubicacion coordenadas4;
	Ubicacion coordenadas5;
	Ubicacion coordenadas6;
	Ubicacion coordenadas7;
	Ubicacion coordenadas8;
	Ubicacion coordenadas9;
	Ubicacion coordenadas10;
	Ubicacion coordenadas11;
	Ubicacion coordenadas12;
	Ubicacion coordenadas13;
	Ubicacion coordenadas14;
	Ubicacion coordenadas15;
	Ubicacion coordenadas16;
	Ubicacion coordenadas17;
	Ubicacion coordenadas18;
	Ubicacion coordenadas19;
	Ubicacion coordenadas20;
	Ubicacion coordenadas21;
	Ubicacion coordenadas22;
	Ubicacion coordenadas23;
	
	Pais pais1;
	Pais pais2;
	Pais pais3;
	Pais pais4;
	Pais pais5;
	Pais pais6;
	Pais pais7;
	Pais pais8;
	Pais pais9;
	Pais pais10;
	Pais pais11;
	Pais pais12;
	Pais pais13;
	Pais pais14;
	Pais pais15;
	
	Ciudad ciudad1;
	Ciudad ciudad2;
	Ciudad ciudad3;
	Ciudad ciudad4;
	Ciudad ciudad5;
	Ciudad ciudad6;
	Ciudad ciudad7;
	Ciudad ciudad8;
	Ciudad ciudad9;
	Ciudad ciudad10;
	Ciudad ciudad11;
	Ciudad ciudad12;
	Ciudad ciudad13;
	Ciudad ciudad14;
	Ciudad ciudad15;
	Ciudad ciudad16;
	Ciudad ciudad17;
	Ciudad ciudad18;
	Ciudad ciudad19;
	Ciudad ciudad20;
	Ciudad ciudad21;
	Ciudad ciudad22;
	Ciudad ciudad23;
	
	
	@Before
	public void precargaDatos () {
		continente1 = new Continente("Oceanía");
		continente2 = new Continente("America");
		continente3 = new Continente("Africa");
		continente4 = new Continente("Asia");
		continente5 = new Continente("Europa");
		getSession().save(continente1);
		getSession().save(continente2);
		getSession().save(continente3);
		getSession().save(continente4);
		getSession().save(continente5);
		
		coordenadas1 = new Ubicacion(-35.2833, 149.1280);
		coordenadas2 = new Ubicacion(-33.8651, 151.2099);
		coordenadas3 = new Ubicacion(-41.2866, 174.7755);
		coordenadas4 = new Ubicacion(-7.7568, -35.3656);
		coordenadas5 = new Ubicacion(-31.4135, -64.1810);
		coordenadas6 = new Ubicacion(-15.7801, -47.9292);
		coordenadas7 = new Ubicacion(-23.5475, -46.6361);
		coordenadas8 = new Ubicacion(-12.0430, -77.0283);
		coordenadas9 = new Ubicacion(-13.5250, -71.9722);
		coordenadas10 = new Ubicacion(14.6919, -17.4474);
		coordenadas11 = new Ubicacion(9.0578, 7.4950);
		coordenadas12 = new Ubicacion(34.0242, -6.8227);
		coordenadas13 = new Ubicacion(55.7522, 37.6155);
		coordenadas14 = new Ubicacion(61.2500, 73.4200);
		coordenadas15 = new Ubicacion(24.7091, 46.7241);
		coordenadas16 = new Ubicacion(28.6100, 77.2300);
		coordenadas17 = new Ubicacion(37.6589, -5.5261);
		coordenadas18 = new Ubicacion(40.4167, -3.7032);
		coordenadas19 = new Ubicacion(39.4698, -0.3774);
		coordenadas20 = new Ubicacion(41.8905, 12.4942);
		coordenadas21 = new Ubicacion(40.8401, 14.2516);
		coordenadas22 = new Ubicacion(48.8667, 2.3333);
		coordenadas23 = new Ubicacion(45.7726, 4.8033);
		getSession().save(coordenadas1);
		getSession().save(coordenadas2);
		getSession().save(coordenadas3);
		getSession().save(coordenadas4);
		getSession().save(coordenadas5);
		getSession().save(coordenadas6);
		getSession().save(coordenadas7);
		getSession().save(coordenadas8);
		getSession().save(coordenadas9);
		getSession().save(coordenadas10);
		getSession().save(coordenadas11);
		getSession().save(coordenadas12);
		getSession().save(coordenadas13);
		getSession().save(coordenadas14);
		getSession().save(coordenadas15);
		getSession().save(coordenadas16);
		getSession().save(coordenadas17);
		getSession().save(coordenadas18);
		getSession().save(coordenadas19);
		getSession().save(coordenadas20);
		getSession().save(coordenadas21);
		getSession().save(coordenadas22);
		getSession().save(coordenadas23);
		
		pais1 = new Pais("Australia", 15100000, "Ingles", continente1);
		pais2 = new Pais("Nueva Zelanda", 5100600, "Maori", continente1);
		pais3 = new Pais("Argentina", 42300000, "Español", continente2);
		pais4 = new Pais("Brasil", 58750000, "Portugues", continente2);
		pais5 = new Pais("Perú", 27500000, "Español", continente2);
		pais6 = new Pais("Senegal", 37850000, "Frances", continente3);
		pais7 = new Pais("Nigeria", 41230000, "Ingles", continente3);
		pais8 = new Pais("Marruecos", 38560000, "Arabe", continente3);
		pais9 = new Pais("Rusia", 87600312, "Ruso", continente4);
		pais10 = new Pais("Arabia Saudita", 63521000, "Arabe", continente4);
		pais11 = new Pais("India", 101500000, "Hindi", continente4);
		pais12 = new Pais("China", 123150000, "Chino", continente4);
		pais13 = new Pais("España", 45623000, "Español", continente5);
		pais14 = new Pais("Italia", 41200000, "Italiano", continente5);
		pais15 = new Pais("Francia", 40390000, "Frances", continente5);

		ciudad1 = new Ciudad("Camberra", pais1, coordenadas1);
		ciudad2 = new Ciudad("Sidney", pais1, coordenadas2);
		ciudad3 = new Ciudad("Wellington", pais2, coordenadas3);
		ciudad4 = new Ciudad("Buenos Aires", pais3, coordenadas4);
		ciudad5 = new Ciudad("Cordoba", pais3, coordenadas5);
		ciudad6 = new Ciudad("Brasilia", pais4, coordenadas6);
		ciudad7 = new Ciudad("San Pablo", pais4, coordenadas7);
		ciudad8 = new Ciudad("Lima", pais5, coordenadas8);
		ciudad9 = new Ciudad("Cusco", pais5, coordenadas9);
		ciudad10 = new Ciudad("Dakar", pais6, coordenadas10);
		ciudad11 = new Ciudad("Abuya", pais7, coordenadas11);
		ciudad12 = new Ciudad("Rabat", pais8, coordenadas12);
		ciudad13 = new Ciudad("Moscu", pais9, coordenadas13);
		ciudad14 = new Ciudad("Surgut", pais9, coordenadas14);
		ciudad15 = new Ciudad("Riad", pais10, coordenadas15);
		ciudad16 = new Ciudad("Nueva Delhi", pais11, coordenadas16);
		ciudad17 = new Ciudad("Yintuan", pais12, coordenadas17);
		ciudad18 = new Ciudad("Madrd", pais13, coordenadas18);
		ciudad19 = new Ciudad("Valencia", pais13, coordenadas19);
		ciudad20 = new Ciudad("Roma", pais14, coordenadas20);
		ciudad21 = new Ciudad("Nápoles", pais14, coordenadas21);
		ciudad22 = new Ciudad("Paris", pais15, coordenadas22);
		ciudad23 = new Ciudad("Lyon", pais15, coordenadas23);
		getSession().save(ciudad1);
		getSession().save(ciudad2);
		getSession().save(ciudad3);
		getSession().save(ciudad4);
		getSession().save(ciudad5);
		getSession().save(ciudad6);
		getSession().save(ciudad7);
		getSession().save(ciudad8);
		getSession().save(ciudad9);
		getSession().save(ciudad10);
		getSession().save(ciudad11);
		getSession().save(ciudad12);
		getSession().save(ciudad13);
		getSession().save(ciudad14);
		getSession().save(ciudad15);
		getSession().save(ciudad16);
		getSession().save(ciudad17);
		getSession().save(ciudad18);
		getSession().save(ciudad19);
		getSession().save(ciudad20);
		getSession().save(ciudad21);
		getSession().save(ciudad22);
		getSession().save(ciudad23);

		
		pais1.setCapital(ciudad1);
		pais2.setCapital(ciudad3);
		pais3.setCapital(ciudad4);
		pais4.setCapital(ciudad6);
		pais5.setCapital(ciudad8);
		pais6.setCapital(ciudad10);
		pais8.setCapital(ciudad12);
		pais9.setCapital(ciudad13);	
		pais10.setCapital(ciudad15);
		pais11.setCapital(ciudad16);
		pais13.setCapital(ciudad18);
		pais14.setCapital(ciudad20);
		pais15.setCapital(ciudad22);		
		
		getSession().save(pais1);
		getSession().save(pais2);
		getSession().save(pais3);
		getSession().save(pais4);
		getSession().save(pais5);
		getSession().save(pais6);
		getSession().save(pais7);
		getSession().save(pais8);
		getSession().save(pais9);
		getSession().save(pais10);
		getSession().save(pais11);
		getSession().save(pais12);
		getSession().save(pais13);
		getSession().save(pais14);
		getSession().save(pais15);		
	}
	
	@Test
	@Transactional
	@Rollback (true)
	public void testQueBuscaTodosLosPaisesDeHablaInglesa() {		
		List <Pais> ingles = getSession().createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "Ingles"))
				.list();
		
		// Verifico que la cantidad de registros devueltos sea la esperada
		Integer valorEsperado = 2;
		Integer valorObtenido = ingles.size();
		assertEquals(valorEsperado, valorObtenido);
		
		//Verifico que los datos devueltos sean los esperados
		Iterator <Pais> r = ingles.iterator();
		Pais registro;
		while(r.hasNext()) {
			registro = r.next();
			assertThat(registro.getIdioma()).isEqualTo("Ingles");
		}
	}

	@Test
	@Transactional
	@Rollback (true)
	public void testQueBuscaTodosLosPaisesDelContinenteEuropeo() {
		List <Pais> continenteEuropeo = getSession().createCriteria(Pais.class)
				.createAlias("continente", "buscaPaises")
				.add(Restrictions.eq("buscaPaises.nombre", "Europa"))
				.list();
		
		// Verifico que la cantidad de registros devueltos sea la esperada
		Integer valorEsperado = 3;
		Integer valorObtenido = continenteEuropeo.size();
		assertEquals(valorEsperado, valorObtenido);
		
		//Verifico que los datos devueltos sean los esperados
		for (Pais registro: continenteEuropeo) {
			assertThat(registro.getContinente().getNombre()).isEqualTo("Europa");
		}
	}

	@Test
	@Transactional
	@Rollback (true)
	public void testQueBuscaTodosLosPaisesCuyaCapitalEstanAlNorteDelTropicoDeCancer() {
		List <Pais> capitalesTropicoCancer = getSession().createCriteria(Pais.class)
				.createAlias("capital", "buscaCapital")
				.createAlias("capital.ubicacion", "buscaLatitud")
				.add(Restrictions.gt("buscaLatitud.latitud", 23.0D))
				.list();
			
		// Verifico que la cantidad de registros devueltos sea la esperada
		Integer valorEsperado = 7;
		Integer valorObtenido = capitalesTropicoCancer.size();
		assertEquals(valorEsperado, valorObtenido);
		
		//Verifico que los datos devueltos sean los esperados
		Iterator <Pais> r = capitalesTropicoCancer.iterator();
		Pais registro;
		while(r.hasNext()) {
			registro = r.next();
			assertTrue(registro.getCapital().getUbicacion().getLatitud()>23.0D);
		}
	}

	@Test
	@Transactional
	@Rollback (true)
	public void testQueBuscaTodasLasCiudadesDelHemisferioSur() {		
		List <Ciudad> hemisferioSur = getSession().createCriteria(Ciudad.class)
				.createAlias("ubicacion", "buscaLatitud")
				.add(Restrictions.lt("buscaLatitud.latitud", 0.0D))
				.list();

		Integer valorEsperado = 9;
		Integer valorObtenido = hemisferioSur.size();
		assertEquals(valorEsperado, valorObtenido);
		
		//Verifico que los datos devueltos sean los esperados
		for (Ciudad registro: hemisferioSur) {
			assertTrue(registro.getUbicacion().getLatitud()<0.0D);
		}
	}

}
