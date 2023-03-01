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
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdaoServicio;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdaoServicioIMPL;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.PortatilDTO;
import edu.dws.gestionMaterialVistas.aplicacion.servicios.Consultas;
@Controller
public class ControladorPortatil {
	@Autowired
	Consultas consulta;
	AdaoServicio convertirAdao=new AdaoServicioIMPL();
	Map<String,Object> modelo = new HashMap<String,Object>();
	List<Portatil> listaPortatiles = new ArrayList<>();
	 protected final Log logger = LogFactory.getLog(getClass());
	 Portatil portatil = new Portatil();
	 
	 
	 
	 //indicamos que en la vista formulario va a recibir un objeto portátil
	 @RequestMapping(value="/Formulario")
	 public String navegacionPortatil(Model modelo) {
		
		 PortatilDTO portatildto = new PortatilDTO();
		 modelo.addAttribute("portatil", portatildto);
		 
		 
		return "Formulario";
		 
	 }
	 
	 //en este caso insertamos el portatil en una lista de portátil y esta en un map, que es el que mandamos a la vista.
	 @RequestMapping(value="/guardarPortatil",method = RequestMethod.POST)
	 public ModelAndView guardarPortatil(@ModelAttribute("portatil") PortatilDTO portatildto) {
		 portatil= convertirAdao.PortatilaDAO(portatildto);
		 listaPortatiles.add(portatil);
		 modelo.put("listaPortatiles", listaPortatiles);
		 consulta.InsertarPortatil(portatil);
		logger.info("correctamente introducido");
		 
		 
		return new ModelAndView("/Formulario","modelo",modelo);
		 
		 
	 }
}
