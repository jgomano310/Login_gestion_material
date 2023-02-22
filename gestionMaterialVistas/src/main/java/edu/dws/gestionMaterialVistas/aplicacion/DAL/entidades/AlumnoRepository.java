package edu.dws.gestionMaterialVistas.aplicacion.DAL.entidades;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

}