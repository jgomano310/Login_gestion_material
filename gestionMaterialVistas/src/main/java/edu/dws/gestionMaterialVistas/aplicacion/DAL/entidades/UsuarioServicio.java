package edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioServicio extends CrudRepository<UsuarioLogin, Long>{ 
	
	
		
		public UsuarioLogin EncontrarContrase├▒a(String nombreUsuario, String password);
	}

