package edu.dws.gestionMaterialVistas.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.UsuarioLogin;

@Controller
public class ControladorLogin {
	
		@RequestMapping(value = "/registro")
		public String registro(Model modelo) {

			
			UsuarioLogin usuario = new UsuarioLogin();
			modelo.addAttribute("usuario", usuario);
			return "registro";
		}
		
			@RequestMapping(value = "/login")
			public String login(Model modelo) {

				UsuarioLogin usuario = new UsuarioLogin();
				modelo.addAttribute("usuario", usuario);
				return "login";
			};
	}
	


