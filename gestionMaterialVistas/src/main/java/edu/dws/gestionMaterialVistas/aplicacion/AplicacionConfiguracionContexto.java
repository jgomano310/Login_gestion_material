package edu.dws.gestionMaterialVistas.aplicacion;

import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Alumno;
import edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades.Portatil;

@Configuration
@ComponentScan
//indicamos la ruta de nuestro archivo properties
@PropertySource("classpath:propiedades.properties")

//examina los paquetes que le indicamos y los habilita
@EnableJpaRepositories("edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades")

public class AplicacionConfiguracionContexto {
	@Autowired
	private Environment enviroment;
	@Bean
	public DataSource dataSource () {
		
		//indicamos todas las propiedades de la interfaz datasource para conectarnos a la base de datos.
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(enviroment.getProperty("db.driver"));
		datasource.setUrl(enviroment.getProperty("db.url"));
		datasource.setUsername(enviroment.getProperty("db.username"));
		datasource.setPassword(enviroment.getProperty("db.password"));
		
		return datasource;
		
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean local = new LocalContainerEntityManagerFactoryBean();
		local.setDataSource(dataSource());
		local.setPackagesToScan(Alumno.class.getPackage().getName());
		
		//configuramos jpa
		 HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
		 jpa.setDatabase(Database.POSTGRESQL);
		 //indicamos el lenguaje de bd que vamos a usar
		 jpa.setDatabasePlatform(enviroment.getProperty("hibernate-dialect"));
		 //lo configuramos para que cree las tablas automaticamente con generateddl=true
		 jpa.setGenerateDdl(enviroment.getProperty("hibernate.generateDdl", Boolean.class));
		 //en mi caso indicamos que no muestre en consola las queries
		 jpa.setShowSql(enviroment.getProperty("hibernate.show_sql", Boolean.class));
	     local.setJpaVendorAdapter(jpa);
	     
	     Properties jpaProp = new Properties();
	     //indicamos que actualize la base de datos cuando se lance
	     jpaProp.put("hibernate.hbm2ddl.auto", enviroment.getProperty("hibernate.hbm2ddl.auto"));
	     
	     jpaProp.put("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
	     jpaProp.put("hibernate.format_sql", enviroment.getProperty("hibernate.format_sql"));
	     local.setJpaProperties(jpaProp);
		return local;
		
	}
	//configuracion del gestor de transacciones
	 @Bean
	    public JpaTransactionManager transactionManager() {
	        JpaTransactionManager jpa = new JpaTransactionManager();
	        jpa.setEntityManagerFactory(entityManagerFactory().getObject());
	        return jpa;
	    }

}
