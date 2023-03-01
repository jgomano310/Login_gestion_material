package edu.dws.gestionMaterialVistas.enrutador;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


import edu.dws.gestionMaterialVistas.aplicacion.AplicacionConfiguracionContexto;
import edu.dws.gestionMaterialVistas.web.WebConfiguracionContexto;




//configuracion de arranque de aplicacion
public class EnrutadorEjemploWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

	   @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class<?>[] { AplicacionConfiguracionContexto.class };
	    }

	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class<?>[] { WebConfiguracionContexto.class };
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }

}
