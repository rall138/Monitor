package com.rldevel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.EstudiantesDAO;
import com.rldevel.Entities.Estudiante;

@Service("estudianteService")
public class EstudianteService {
	
	EstudiantesDAO estudianteDAO;
	
	public void agregarEstudiante(Estudiante estudiante){
		estudianteDAO.agregarEstudiante(estudiante);
	}

	public EstudiantesDAO getEstudianteDAO() {
		return estudianteDAO;
	}

	@Autowired
	public void setEstudianteDAO(EstudiantesDAO estudianteDAO) {
		this.estudianteDAO = estudianteDAO;
	}
	
	public List<Estudiante> getColeccionEstudiantes(){
		return estudianteDAO.getColeccionEstudiantes();
	}
	
	
}
