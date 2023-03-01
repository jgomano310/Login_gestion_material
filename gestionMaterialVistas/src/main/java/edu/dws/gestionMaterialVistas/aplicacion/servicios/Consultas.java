package edu.dws.gestionMaterialVistas.aplicacion.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.AlumnoRepository;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.PortatilRepository;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AdtoServicioIMPL;
import edu.dws.gestionMaterialVistas.aplicacion.DTO.AlumnoDTO;
@Service
//clase para realizar consultas con base de datos
public class Consultas {

	AdtoServicioIMPL ADTO = new AdtoServicioIMPL();
	@Autowired
	AlumnoRepository alumnoR;
	
	@Autowired
	PortatilRepository portatilR;
	
	
	//método insertar alumno
	@Transactional
	public void InsertarAlumno(Alumno alumno) {
		try {
		alumnoR.save(alumno);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	@Transactional
	//método insertar portátil
	public void InsertarPortatil(Portatil portatil) {
		try {
		portatilR.save(portatil);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//Buscar todos los portátiles
	@Transactional
	public List<Portatil> buscarTodos() {
		try {
		
		return (List<Portatil>) portatilR.findAll();
		}
	catch(Exception e) {
		System.out.println(e);
	}
		return null;
	}
	
	@Transactional
	//Buscar alumnos
public List<Alumno> buscarTodosAlumnosdao() {
		List<Alumno> lista = new ArrayList<>();
		
		try {
		for(Alumno alumno : alumnoR.findAll() ){
			lista.add(alumno);
		
		
		}
		}catch(Exception e) {
			System.out.println(e);
			lista=null;
		}
		return lista;
		
		
	}
	@Transactional
	
	//buscar lista de alumnos para mostrarla en vista
	public List<AlumnoDTO> buscarTodosAlumnosdto() {
		try {
		List<Alumno> lista = (List<Alumno>) alumnoR.findAll();
		List<AlumnoDTO> listadto =  ADTO.ListaAlumnosAdto(lista);
		
		
		
		return listadto;
		}catch(Exception e) {
			System.out.println(e);
			return null;

		}
		
		
	}
	
	@Transactional
	
	//lista de portatil asignado a un alumno
	public Portatil listarPortatilPorId(int id_alumno) {
		try {
		Alumno alumno = alumnoR.findById(id_alumno).get();
		Portatil portatil = alumno.getPortatil();
		return portatil;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Transactional
	//Borrar alumno
	public void BorrarAlumno(int id_Alumno) {
		try {
		alumnoR.deleteById(id_Alumno);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Transactional
	//alumno asignado a un portátil
	public Alumno listAlumnosPorId(int id_portatil) {
		try {
		Portatil portatil = portatilR.findById(id_portatil).get();
		Alumno alumno = portatil.getAlumno();
		return alumno;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}	
}
	
	

