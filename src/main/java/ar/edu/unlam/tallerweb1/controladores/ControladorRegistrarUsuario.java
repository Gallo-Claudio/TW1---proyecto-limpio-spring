package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresoUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarPersonas;


@Controller
public class ControladorRegistrarUsuario {

	@Inject
	private ServicioIngresoUsuario servicioIngresoUsuario;
	@Inject
	private ServicioListarPersonas servicioListarPersonas;


	@RequestMapping(path = "/ingreso-usuario", method = RequestMethod.GET)
	public ModelAndView presentarFormulario() {
		Persona persona = new Persona();
		ModelMap model = new ModelMap();
		model.put("persona", persona);
		return new ModelAndView("ingreso-usuario", model);
	}
	
	@RequestMapping(path = "/registro-usuario", method = RequestMethod.POST)
	public ModelAndView ingresoUsuario (@ModelAttribute ("agregarusuario") Persona persona) {
		servicioIngresoUsuario.ingresarUsuario(persona);   // Paso el objeto "persona" que recibo desde el formulario a traves del ModelAttribute, al area de Servicios desde donde se maneja la lógica
		return new ModelAndView("redirect:/ingreso-usuario"); // Retorna a la vista del formulario (ingreso de datos)
	}
	
	@RequestMapping(path = "/lista-final", method = RequestMethod.GET)
	public ModelAndView listadoPersonas () {
		ModelMap modelo = new ModelMap();
		// Llamo al metodo "listarPersonas()" de la instancia del objeto "servicioListarPersonas", que esta en el area de Servicios.
		// El valor obtenido es agregado como "value" en el model(KEY/VALUE) a traves del .put
		// Para luego pasarlo a la vista a traves del return ModelAndView
		modelo.put("listaf", servicioListarPersonas.listarPersonas());
		return new ModelAndView("listado-final", modelo);
	}
	
}
