package es.pildoras.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HolaAlumnosControlador {
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {//proporciona el formulario
		return "holaAlumnosFormulario";
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario() {
		return "holaAlumnosSpring";
	}

	@RequestMapping("/procesarFormulario2")
	//public String otroProcesoFormulario(HttpServletRequest request, Model modelo) {	
	public String otroProcesoFormulario(@RequestParam("nombreAlumno") String nombre, Model modelo) {
		
		//String nombre = request.getParameter("nombreAlumno");// viene del input text name="nombreAlumno"
		
		nombre += " es el mejor alumno"; // concatenamos lo que guardamos en la variable 'nombre' el texto 'es el mejor alumno'
		
		String mensajeFinal = "¿Quien es el mejor alumno? " + nombre;
		
		//Agregando info al modelo
		modelo.addAttribute("mensajeClaro", mensajeFinal);
		
		return "holaAlumnosSpring";
	}
	
}
