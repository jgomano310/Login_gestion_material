package edu.dws.gestionMaterialVistas.aplicacion.DTO;

import java.util.Calendar;
import java.util.Random;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;

public class AdaoServicioIMPL implements AdaoServicio {

	
	
	@Override
	public Alumno AlumnoaDAO(AlumnoDTO alumnoDTO) {
		String muuid = java.util.UUID.randomUUID().toString();
		Alumno alumno = new Alumno();
		Calendar c1 = Calendar.getInstance();
		Random azar = new Random(5000);
		
		if(alumnoDTO!=null) {
			alumno.setMd_uuid(muuid);
			alumno.setNombre(alumnoDTO.getNombre());
			alumno.setTeléfono(alumnoDTO.getTelefono());
			alumno.setMd_date(c1);
			alumno.setIdAlumno(alumnoDTO.getIdAlumno());
			alumno.setPortatil(alumnoDTO.getPortatil());
		}
		
		
		return alumno;
	}

	@Override
	public Portatil PortatilaDAO(PortatilDTO portatilDTO) {
		// TODO Auto-generated method stub
		String muuid = java.util.UUID.randomUUID().toString();
		Calendar c1 = Calendar.getInstance();
		Portatil portatil = new Portatil();
		
		if(portatilDTO!=null) {
			portatil.setId(portatilDTO.getId());
			portatil.setMd_uuid(muuid);
			portatil.setMarca(portatilDTO.getMarca());
			portatil.setMd_date(c1);
			portatil.setModelo(portatilDTO.getModelo());
			portatil.setAlumno(portatilDTO.getAlumno());
		}
		
		
		return portatil;
	}

}
