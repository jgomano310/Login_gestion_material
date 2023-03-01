package edu.dws.gestionMaterialVistas.aplicacion.DTO;




import java.util.Calendar;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
public interface AdtoServicio {
	
	public AlumnoDTO AlumnoaDTO (Alumno alumno);
	
	
	
	
	
	public PortatilDTO PortatilaDTO(int id_alumno, Calendar md_date,String marca,String modelo);
	
	

	
}
