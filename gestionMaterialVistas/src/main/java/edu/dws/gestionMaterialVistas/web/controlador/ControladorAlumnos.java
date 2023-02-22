package edu.dws.gestionMaterialVistas.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.AlumnoRepository;
import edu.dws.gestionMaterialVistas.aplicacion.servicios.Consultas;

@Controller
public class ControladorAlumnos {
	
	@Autowired
	Consultas consulta;
	
	Map<String,Object> modelo = new HashMap<String,Object>();
	List<Alumno> listaAlumnos = new ArrayList<>();
	 protected final Log logger = LogFactory.getLog(getClass());
	
	
	
	@RequestMapping("Formulario")
	public String Navegacion(Model modelo) {
	
		Alumno alumno = new Alumno();
		
		modelo.addAttribute("alumno",alumno);
		
		return "formulario";
		
		
		
	}
	
	 @RequestMapping(value="/guardarAlumno",method = RequestMethod.POST)
	    public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		 
	    	logger.info("guardando alumno");
	    	
	    	consulta.InsertarAlumno(alumno);
	    	
	    	modelo.put("listaAlumnos",alumno);
	    	
	    	
	    	
			return new ModelAndView("Formulario", "modelo",modelo);
	    	
	    }
	

}
