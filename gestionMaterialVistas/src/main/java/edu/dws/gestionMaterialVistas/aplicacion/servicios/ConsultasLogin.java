package edu.dws.gestionMaterialVistas.aplicacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.UsuarioLogin;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.UsuarioServicio;

@Service
public class ConsultasLogin {
	
	@Autowired
	private UsuarioServicio us;
	
	public void registrar(UsuarioLogin usuario){
		try {
			us.save(usuario);
		}catch(Exception e) {
			System.out.println(e);
		}
    }
	
	public void verificarCredenciales(String nombreUsuario, String password) {
		us.EncontrarContraseña(nombreUsuario, password);
	}
}


