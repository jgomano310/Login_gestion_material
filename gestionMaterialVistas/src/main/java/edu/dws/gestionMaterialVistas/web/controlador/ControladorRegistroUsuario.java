package edu.dws.gestionMaterialVistas.web.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.UsuarioLogin;
import edu.dws.gestionMaterialVistas.aplicacion.servicios.ConsultasLogin;

@Controller
public class ControladorRegistroUsuario {
	@Autowired
	ConsultasLogin consulta;

	
	Map<String, Object> miModelo = new HashMap<String, Object>();

	
	
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("usuario") UsuarioLogin usuario) {
		try {
			

			if (Long.toString(usuario.getId()).isEmpty() || usuario.getNombre().isEmpty()
					|| usuario.getApellidos().isEmpty() || usuario.getNombreUsuario().isEmpty()
					|| usuario.getPassword().isEmpty()) {
				miModelo.put("Mensaje", "campos no validos");
				return new ModelAndView("registro", "miModelo", miModelo);
			} else {
				
				consulta.registrar(usuario);
				miModelo.put("Mensaje", " completado correctamente");
			}
			return new ModelAndView("login", "miModelo", miModelo);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView iniciarSesion(@ModelAttribute("usuario") UsuarioLogin usuario) {
	    try {
	    	
	        
	    	consulta.verificarCredenciales(usuario.getNombreUsuario(), usuario.getPassword());
	    	
	        if (usuario != null) {
	        	
	        	miModelo.put("Mensaje", "Has iniciado sesión");
				return new ModelAndView("../index", "miModelo", miModelo);
	        } else {
	        	miModelo.put("Mensaje", "EL usuario o contraseña son incorrectos");
				return new ModelAndView("login", "miModelo", miModelo);
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}
}
