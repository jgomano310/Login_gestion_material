package edu.dws.gestionMaterialVistas.aplicacion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//clase de configuración de seguridad
public class SeguridadAppconfid extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}

	@Override
	//peticiones de usuarios no autentificados
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
		.loginProcessingUrl("/autenticacionUsuario")
		
		//Esto permite ver a todo los usuarios el login sin necesidad de estar registrado
		.permitAll();
	}
	
	
	
	

}
