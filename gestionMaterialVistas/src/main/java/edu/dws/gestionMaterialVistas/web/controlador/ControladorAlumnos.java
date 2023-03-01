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
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdaoServicio;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdaoServicioIMPL;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AlumnoDTO;
import edu.dws.gestionMaterialVistas.aplicacion.servicios.Consultas;

@Controller
public class ControladorAlumnos {
	
	@Autowired
	Consultas consulta;
	
	Map<String,Object> modelo = new HashMap<String,Object>();
	List<Alumno> listaAlumnos = new ArrayList<>();
	List<Portatil> listaPortatillibres = new ArrayList<>();
	List<Integer> listaPortatilnoLibres = new ArrayList<>();
	Alumno alumno = new Alumno();
	Portatil portatilBueno = new Portatil();
	 protected final Log logger = LogFactory.getLog(getClass());
	
	AdaoServicio adao = new AdaoServicioIMPL();
	
	@RequestMapping(value="FormularioAlumno")
	public String NavegacionAlumno(Model modelo) {
	
		AlumnoDTO alumnodto = new AlumnoDTO();
		
		//enviamos el objeto dto a la vista
		modelo.addAttribute("alumno",alumnodto);
		
		return "FormularioAlumno";
		
		
		
	}
	
	 @RequestMapping(value="/guardarAlumno",method = RequestMethod.POST)
	    public ModelAndView guardarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnodto) {
	    	
	    	
	    	Portatil portatil1 = new Portatil();
	    	
	    	//recorremos los alumnos, y si esta asignado lo metemos en una lista e portatiles que están ocupados
	    	for(Alumno alumno : consulta.buscarTodosAlumnosdao()){
	    		if(alumno.getPortatil()!=null) {
	    			listaPortatilnoLibres.add ((Integer)(alumno.getPortatil().getId()));
	    		}
	    	}
	    	
	    	//recorremos los portátiles y si la lista no contiene el id que pasamos por la vista lo seleccionamos
	    	//y se lo añadimos al alumno.
	    	
	    	for(Portatil portatil: consulta.buscarTodos()) {
	    		
	    		if(!listaPortatilnoLibres.contains(portatil.getId())) {
	    			portatilBueno=portatil;
	    		}else {
	    			portatilBueno=null;
	    		}
	    		
	    	}
	    	alumnodto.setPortatil(portatilBueno);
	    	
	    	consulta.InsertarAlumno(adao.AlumnoaDAO(alumnodto));
	    	
	    	logger.info("alumno introducido!!");
	    	
	    	
	    	
	    	
			return new ModelAndView("FormularioAlumno", "modelo",modelo);
	    	
	    }
	

}
