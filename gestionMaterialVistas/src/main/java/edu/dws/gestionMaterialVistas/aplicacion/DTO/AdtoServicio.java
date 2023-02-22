package edu.dws.gestionMaterialVistas.aplicacion.DTO;




import java.util.Calendar;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
public interface AdtoServicio {
	
	public AlumnoDTO AlumnoaDTO (Calendar md_date, String nombre, String telefono, Portatil portatil);
	
	
	
	
	
	public PortatilDTO PortatilaDTO( Calendar md_date,String marca,String modelo);
	
	

	
}
