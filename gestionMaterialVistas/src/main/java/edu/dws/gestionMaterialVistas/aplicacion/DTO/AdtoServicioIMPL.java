package edu.dws.gestionMaterialVistas.aplicacion.DTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
public class AdtoServicioIMPL {

	public AlumnoDTO AlumnoaDTO(Alumno alumno) {
		AlumnoDTO alumnoDTO= new AlumnoDTO(alumno.getMd_date(),  alumno.getNombre(),  alumno.getTelefono(), alumno.getIdAlumno(), alumno.getPortatil());
		
		return alumnoDTO;
	}

	
	public PortatilDTO PortatilaDTO(Portatil portatil) {
		PortatilDTO portatilDTO = new PortatilDTO( portatil.getMarca(),  portatil.getModelo(), portatil.getId());
		
		return portatilDTO;
	}
	
	public List<AlumnoDTO> ListaAlumnosAdto(List<Alumno> alumnodto) {
		List<AlumnoDTO> lista = new ArrayList<AlumnoDTO>();
		for (Alumno alumno : alumnodto) {
			lista.add(AlumnoaDTO(alumno));
		}
		return lista;
	}

	




}
