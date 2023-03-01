package edu.dws.gestionMaterialVistas.aplicacion.DTO;



import java.util.Calendar;

import javax.persistence.Column;


import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;
public class PortatilDTO {
	
	
	private Calendar md_date;
	
	private String marca;
	
	private String modelo;
	private int id;
	private Alumno alumno;
	
	
	public PortatilDTO( String marca, String modelo, int id) {
		super();
		
		this.marca = marca;
		this.modelo = modelo;
		this.id = id;
		
	}
	

	public PortatilDTO(Calendar md_date, String marca, String modelo, int id, Alumno alumno) {
		super();
		this.md_date = md_date;
		this.marca = marca;
		this.modelo = modelo;
		this.id = id;
		this.alumno = alumno;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getMd_date() {
		return md_date;
	}

	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	


	public PortatilDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PortatilDTO [md_date=" + md_date + ", marca=" + marca + ", modelo=" + modelo + 
				"]";
	}

	
	

	
	
	

}
