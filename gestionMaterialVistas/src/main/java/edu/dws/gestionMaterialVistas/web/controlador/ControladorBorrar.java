package edu.dws.gestionMaterialVistas.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdtoServicio;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdtoServicioIMPL;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AlumnoDTO;
import edu.dws.gestionMaterialVistas.aplicacion.servicios.Consultas;

@Controller
public class ControladorBorrar {
	@Autowired
	Consultas consulta;
AlumnoDTO alumnodto = new AlumnoDTO();
Alumno alumno = new Alumno();

Map<String,Object> modelo = new HashMap<String,Object>();


//listamos los alumnos añadiendo todos lo existentes a una lista de dto, lo añadimos a un mapa
//y este se lo pasamos a la vista con el modelandview
@RequestMapping(value="/ListarBorrarAlumno", method = RequestMethod.GET)
public ModelAndView listaAlumnos() {
	List<AlumnoDTO> listAlumnos= consulta.buscarTodosAlumnosdto();
	modelo.put("listaAlumnos", listAlumnos);
	
	return new ModelAndView("ListarBorrarAlumno", "modelo", modelo);
	
}


//metodo eliminar en el que con @RequestMapping extraemos el valor del campo id_alumno y borramos.
//devolvemos la mista vista pero con el alumno ya borrado
@RequestMapping(value ="/eliminar")
public ModelAndView eliminarAlumno(@RequestParam int id_alumno) {
	consulta.BorrarAlumno(id_alumno);
	return new ModelAndView("ListarBorrarAlumno");
}
}

