package edu.dws.gestionMaterialVistas.web.controlador;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdtoServicio;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdtoServicioIMPL;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AlumnoDTO;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.PortatilDTO;
import edu.dws.gestionMaterialVistas.aplicacion.servicios.Consultas;
@Controller
public class ControladorAlumnoPorId {

	@Autowired
	Consultas consulta;
	AdaoServicio adao = new AdaoServicioIMPL();
	AdtoServicioIMPL adto = new AdtoServicioIMPL();
	List<Portatil>listaPortatiles = new ArrayList<>();
	
	
	//con requesMapping le decimos a que url ir
	@RequestMapping(value ="/listarAlumnoPorIdPortatil")
	//le pasamos el modelo para después mostrarlo en la vista llamándolo
	public String listarAlumnoPorIdPortatil(Model modelo) {
		PortatilDTO portatil = new PortatilDTO();
		modelo.addAttribute("portatil",portatil);
		return "listarAlumnoPorIdPortatil";
	}
	
	//en este caso usamos @RequestMapping para llamar al método desde la vista
	
	@RequestMapping(value="/guardarAlumnoporId", method = RequestMethod.POST)
	
	public ModelAndView guardarAlumnoporId(@ModelAttribute("portatil") PortatilDTO portatil, Model model) {
		Portatil portatilDAO = adao.PortatilaDAO(portatil);
		Alumno alumno = consulta.listAlumnosPorId(portatilDAO.getId());
		AlumnoDTO alumnodto = adto.AlumnoaDTO(alumno);
		model.addAttribute("alumnodto", alumnodto);
		
		//devuelve la vista (Mialumno) después de introducir los datos
		return new ModelAndView("mialumno");
		
		
	}
		
	}
	

