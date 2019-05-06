package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class testCiudadPaisContinente extends SpringTest {

	
	@Test
	@Transactional
	@Rollback (true)
	public void test4() {
		Continente continente1 = new Continente("Oceanía");
		Continente continente2 = new Continente("America");
		Continente continente3 = new Continente("Africa");
		Continente continente4 = new Continente("Asia");
		Continente continente5 = new Continente("Europa");
		
		Ubicacion coordenadas1 = new Ubicacion(-35.2833, 149.1280);
		Ubicacion coordenadas2 = new Ubicacion(-33.8651, 151.2099);
		Ubicacion coordenadas3 = new Ubicacion(-41.2866, 174.7755);
		Ubicacion coordenadas4 = new Ubicacion(-7.7568, -35.3656);
		Ubicacion coordenadas5 = new Ubicacion(-31.4135, -64.1810);
		Ubicacion coordenadas6 = new Ubicacion(-15.7801, -47.9292);
		Ubicacion coordenadas7 = new Ubicacion(-23.5475, -46.6361);
		Ubicacion coordenadas8 = new Ubicacion(-12.0430, -77.0283);
		Ubicacion coordenadas9 = new Ubicacion(-13.5250, -71.9722);
		Ubicacion coordenadas10 = new Ubicacion(14.6919, -17.4474);
		Ubicacion coordenadas11 = new Ubicacion(9.0578, 7.4950);
		Ubicacion coordenadas12 = new Ubicacion(34.0242, -6.8227);
		Ubicacion coordenadas13 = new Ubicacion(55.7522, 37.6155);
		Ubicacion coordenadas14 = new Ubicacion(61.2500, 73.4200);
		Ubicacion coordenadas15 = new Ubicacion(24.7091, 46.7241);
		Ubicacion coordenadas16 = new Ubicacion(28.6100, 77.2300);
		Ubicacion coordenadas17 = new Ubicacion(37.6589, -5.5261);
		Ubicacion coordenadas18 = new Ubicacion(40.4167, -3.7032);
		Ubicacion coordenadas19 = new Ubicacion(39.4698, -0.3774);
		Ubicacion coordenadas20 = new Ubicacion(41.8905, 12.4942);
		Ubicacion coordenadas21 = new Ubicacion(40.8401, 14.2516);
		Ubicacion coordenadas22 = new Ubicacion(48.8667, 2.3333);
		Ubicacion coordenadas23 = new Ubicacion(45.7726, 4.8033);
		
		Pais pais1 = new Pais("Australia", 15100000, "Ingles", continente1);
		Pais pais2 = new Pais("Nueva Zelanda", 5100600, "Maori", continente1);
		Pais pais3 = new Pais("Argentina", 42300000, "Español", continente2);
		Pais pais4 = new Pais("Brasil", 58750000, "Portugues", continente2);
		Pais pais5 = new Pais("Perú", 27500000, "Español", continente2);
		Pais pais6 = new Pais("Senegal", 37850000, "Frances", continente3);
		Pais pais7 = new Pais("Nigeria", 41230000, "Ingles", continente3);
		Pais pais8 = new Pais("Marruecos", 38560000, "Arabe", continente3);
		Pais pais9 = new Pais("Rusia", 87600312, "Ruso", continente4);
		Pais pais10 = new Pais("Arabia Saudita", 63521000, "Arabe", continente4);
		Pais pais11 = new Pais("India", 101500000, "Hindi", continente4);
		Pais pais12 = new Pais("China", 123150000, "Chino", continente4);
		Pais pais13 = new Pais("España", 45623000, "Español", continente5);
		Pais pais14 = new Pais("Italia", 41200000, "Italiano", continente5);
		Pais pais15 = new Pais("Francia", 40390000, "Frances", continente5);
		
		Ciudad ciudad1 = new Ciudad("Camberra", pais1, coordenadas1);
		Ciudad ciudad2 = new Ciudad("Sidney", pais1, coordenadas2);
		Ciudad ciudad3 = new Ciudad("Wellington", pais2, coordenadas3);
		Ciudad ciudad4 = new Ciudad("Buenos Aires", pais3, coordenadas4);
		Ciudad ciudad5 = new Ciudad("Cordoba", pais3, coordenadas5);
		Ciudad ciudad6 = new Ciudad("Brasilia", pais4, coordenadas6);
		Ciudad ciudad7 = new Ciudad("San Pablo", pais4, coordenadas7);
		Ciudad ciudad8 = new Ciudad("Lima", pais5, coordenadas8);
		Ciudad ciudad9 = new Ciudad("Cusco", pais5, coordenadas9);
		Ciudad ciudad10 = new Ciudad("Dakar", pais6, coordenadas10);
		Ciudad ciudad11 = new Ciudad("Abuya", pais7, coordenadas11);
		Ciudad ciudad12 = new Ciudad("Rabat", pais8, coordenadas12);
		Ciudad ciudad13 = new Ciudad("Moscu", pais9, coordenadas13);
		Ciudad ciudad14 = new Ciudad("Surgut", pais9, coordenadas14);
		Ciudad ciudad15 = new Ciudad("Riad", pais10, coordenadas15);
		Ciudad ciudad16 = new Ciudad("Nueva Delhi", pais11, coordenadas16);
		Ciudad ciudad17 = new Ciudad("Yintuan", pais12, coordenadas17);
		Ciudad ciudad18 = new Ciudad("Madrd", pais13, coordenadas18);
		Ciudad ciudad19 = new Ciudad("Valencia", pais13, coordenadas19);
		Ciudad ciudad20 = new Ciudad("Roma", pais14, coordenadas20);
		Ciudad ciudad21 = new Ciudad("Nápoles", pais14, coordenadas21);
		Ciudad ciudad22 = new Ciudad("Paris", pais15, coordenadas22);
		Ciudad ciudad23 = new Ciudad("Lyon", pais15, coordenadas23);
		
/*		pais1.setCapital(ciudad1);
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
		pais15.setCapital(ciudad22);*/
		
		
		List <Pais> ingles = getSession().createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "Ingles"))
				.list();
		
		
		Integer valorEsperado = 2;
		Integer valorObtenido = ingles.size();
		assertEquals(valorEsperado, valorObtenido);
		
	}

}
