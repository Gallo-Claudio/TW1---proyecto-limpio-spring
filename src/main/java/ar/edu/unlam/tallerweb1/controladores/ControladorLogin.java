package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo); //En la vista (archivo.jsp) lo llamo con la key del map, en este caso "usuario"
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/home");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}	
	
	
////////////////////////////////// Agrgado en la clase de MVC del 02/05/2019 //////////////////////////////	
	@RequestMapping(path = "/hola")      // *HOLAS - Path (ruta) con la que llamo a la vista desde el navegador
	public ModelAndView verHolaMundo(){     // *VERHOLAMUNDO - Nombre como llamo al metodo asociado al RequestMapping
		ModelMap modelo = new ModelMap();   //Coleccion Map
		String nombre = "Ricardo";

		modelo.put("nombre", nombre);       //Agrego una [key] y [value] en la coleccion Map
				
		return new ModelAndView("holamundo", modelo);   // *HOLAMUNDO - Nombre de la vista (archivos con la extension .jsp)
		
		// Los nombres del path, del metodo y de la vista, pueden llamarse de forma distinta entre si. Pero se recomienda que tengan el mismo nombre para mantener una coherencia y mayor claridad

	}
	
	@RequestMapping(path = "/verusuario")
	public ModelAndView verUsuarios(){
		ModelMap modelo = new ModelMap(); //Coleccion Map
		
		Usuario us1 = new Usuario();
		us1.setEmail("andres@gmail.com");
		us1.setRol("Admin");
		
		Usuario us2 = new Usuario();
		us2.setEmail("sebastian@gmail.com");
		us2.setRol("User");
		
		modelo.put("usuario1", us1);
		modelo.put("sebastian", us2);
		
		return new ModelAndView("verusuarios", modelo);
	}
// *************************************************************************************************


////////////////////////////////////// Clase del 9/5/2019 //////////////////////////////////////////

	/// USO DEL REQUESTPARAM
	/// Metodo Get lleva datos desde el controlador hacia la vista
	/// Anotacion en la URL - localhost:8080/holis?nombre=VARAIBLE1&apellido=VARIABLE2
@RequestMapping(path = "/holis", method = RequestMethod.GET)   //Request mapping --->"action"  (Url+Metodo Http) por default es Get, (si no se pone)
public ModelAndView holis(@RequestParam (value="nombre") String firstname, @RequestParam (value="apellido") String secondname){        /// Metodo que devuelve la vista
ModelMap modelo = new ModelMap();                             //Coleccion Map (Key-Value)   ---> Creo un modelo - A traves del Map viajan los datos
modelo.put ("nombrePersona", firstname);					  // Key=nombrePersona    Value=firstname
modelo.put ("apellidoPersona", secondname);                   // Key=apellidoPersona  Value=secondname

return new ModelAndView("holis", modelo);        // [holis] nombre de la vista - [modelo] nombre de la coleccion Map, estamos pasando la informacion que esta en el MAp
}

//**************************************************************************************************
	
	
/////////////////////////////// Actions pasados por Agustina (con sus respectivas vistas) - Ejercicios del 9/5/2019 ///////////////////////////////////////	
	
@RequestMapping( "/bienvenido")    
public ModelAndView metodo() {     
	ModelMap modelo = new ModelMap();
	
	modelo.put("saludo", "hola rocio");
	
	return new ModelAndView("bienvenido",modelo);   
	
}

@RequestMapping( "/holan")
public ModelAndView lista(){
	ModelMap modelo = new ModelMap();
	List<String> lista= new ArrayList();
	modelo.put("saludo", "hola rocio");
	
	return new ModelAndView("bienvenido",modelo);
}

@RequestMapping(path = "variables/{caracteres}/{repeticion}", method = RequestMethod.GET)
public ModelAndView cambiarCaracteres(@PathVariable ("caracteres")String caracter, @PathVariable ("repeticion")Integer repeticion) {
	ModelMap model = new ModelMap();
	List<String> lista = new ArrayList();
	//String caracter= "caracteres";
	
	
	for(int i=0;i<repeticion;i++){
		lista.add(caracter);
	model.put("listaKey", lista);}
	
	
	//String cadenaAconvertir= cadena.toUpperCase();
	
	//model.put("cadenaModel", cadenaAconvertir + cadena);

	
		return new ModelAndView("cadena",model);
	}

@RequestMapping(path = "modelattribute/{caracteres}/{repeticion}", method = RequestMethod.POST)
public ModelAndView cambiar(@PathVariable ("caracteres")String caracter,@PathVariable ("repeticion")Integer repeticion) {
	ModelMap model = new ModelMap();
	List<String> lista = new ArrayList();
	//String caracter= "caracteres";
	
	
	for(int i=0;i<repeticion;i++){
		lista.add(caracter);
	model.put("listaKey", lista);}
	
	
	//String cadenaAconvertir= cadena.toUpperCase();
	
	//model.put("cadenaModel", cadenaAconvertir + cadena);

	
		return new ModelAndView("cadena",model);
	}

@RequestMapping(path = "/saludar", method = RequestMethod.GET)
public ModelAndView saludar (@RequestParam (value="nombre") String nombre, @RequestParam (value="ap") String apellido) {
	ModelMap model = new ModelMap();
	//List<String> lista = new ArrayList();
	//String caracter= "caracteres";
	//lista.add(caracter);
	
	model.put("nombre", nombre);
	model.put("ap",apellido);
	
	
	//String cadenaAconvertir= cadena.toUpperCase();
	
	//model.put("cadenaModel", cadenaAconvertir + cadena);

	
		return new ModelAndView("cadena",model);
	}

/*@RequestMapping(path = "/saludar", method = RequestMethod.GET)
public ModelAndView Otro(){ 
	ModelMap model = new ModelMap();
	//List<String> lista = new ArrayList();
	//String caracter= "caracteres";
	//lista.add(caracter);
	
	//model.put("nombre", nombre);
	//model.put("ap",apellido);
	model.put("cadenaModel", "hola");
	
	
	//String cadenaAconvertir= cadena.toUpperCase();
	
	//model.put("cadenaModel", cadenaAconvertir + cadena);

	
		return new ModelAndView("cadena",model);
	}
*/

@RequestMapping( "/usuarios")
public ModelAndView metodouser() {
	ModelMap modelo = new ModelMap();
	Usuario user1=new Usuario();
	user1.setEmail("user_primero@hotmail.com");
	user1.setPassword("41894367");
	user1.setRol("usuario");
	Usuario user2=new Usuario();
	user2.setEmail("user_segundo@64hotmail.com");
	user2.setPassword("76349814");
	user2.setRol("administrador");

	modelo.put("usuario1", user1);
	modelo.put("usuario2", user2);
	return new ModelAndView("usuarios", modelo);
}

	//**********************************************************************************************************************************


/////////////////////////////////////////////////// EJERCICIO //////////////////////////////////////////////////////////////////

// action 1 - Generar vista formulario y le paso objeto persona vacio
// action 2 - Pasa los datos por POST
// action 3 - Generar vista listado


//ACTION 1
@RequestMapping("/formulario")
public ModelAndView presentarFormulario() {
	ModelMap modelo = new ModelMap();
	Persona persona = new Persona();
	modelo.put("identidad", persona);	
	
	return new ModelAndView ("formulario", modelo);
}

List <Persona> listadoPersonas = new ArrayList();
//ACTION 2
@RequestMapping(path = "/formulario", method = RequestMethod.POST)
public ModelAndView agregar(@ModelAttribute("usuarioPersona") Persona usuarioPersona, HttpServletRequest request) {
	
	listadoPersonas.add(usuarioPersona);
	
	return new ModelAndView("redirect:/formulario");	
}

//ACTION 3
@RequestMapping("/listado")
public ModelAndView listarPersonas() {
	ModelMap listar = new ModelMap();
	listar.put("listadop", listadoPersonas);
	
	return new ModelAndView("listado", listar);
}


//******************************************************************************************************************************



	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
}
