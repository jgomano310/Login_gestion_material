package edu.dws.gestionMaterialVistas.aplicacion.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.AlumnoRepository;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.PortatilRepository;
@Service
public class Consultas {

	@Autowired
	AlumnoRepository alumnoR;
	
	@Autowired
	PortatilRepository portatilR;
	
	@Transactional
	public void InsertarAlumno(Alumno alumno) {
		alumnoR.save(alumno);
	}
	@Transactional
	public void InsertarPortatil(Portatil portatil) {
		portatilR.save(portatil);
	}
}
