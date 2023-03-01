package edu.dws.gestionMaterialVistas.web.controlador;

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
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdtoServicioIMPL;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AlumnoDTO;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.PortatilDTO;
import edu.dws.gestionMaterialVistas.aplicacion.servicios.Consultas;
@Controller
public class ControladorPortatilPorId {
	@Autowired
	Consultas consulta;
	AdaoServicio adao = new AdaoServicioIMPL();
	AdtoServicioIMPL adto = new AdtoServicioIMPL();
	List<Portatil>listaPortatiles = new ArrayList<>();
	
	
	//envio a la vista mi objeto alumnodto
	@RequestMapping(value="/listarPortatilPorid")
	public String MostrarPortatil(Model modelo) {
		AlumnoDTO alumnodto = new AlumnoDTO();
		modelo.addAttribute("alumnodto", alumnodto);
		
		return"listarPortatilPorid";
		
	}
	
	//examino que portatil esta asignado y lo devuelvo.
	@RequestMapping(value="/guardarPortatilporId", method = RequestMethod.POST)
	public ModelAndView guardarPortatilporId(@ModelAttribute("alumnodto") AlumnoDTO alumnoDTO, Model modelo) {
		Alumno alumno= adao.AlumnoaDAO(alumnoDTO);
		
		
		Portatil portatil = new Portatil();
		 portatil = consulta.listarPortatilPorId(alumno.getIdAlumno());
		PortatilDTO portatildto = adto.PortatilaDTO(portatil);
		modelo.addAttribute("portatildto", portatildto);
		return new ModelAndView("Portatil");
		
	}
	
}
