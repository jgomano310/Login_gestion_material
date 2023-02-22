package edu.dws.gestionMaterialVistas.aplicacion.DTO;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;


public interface AdaoServicio {

	
	public Alumno AlumnoaDAO(AlumnoDTO alumnoDTO);
	
	public Portatil PortatilaDAO(PortatilDTO portatilDTO);
}
