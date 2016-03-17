package com.rldevel.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.rldevel.Entities.Estudiante;

@Repository //Repositorio impĺica que esta clase es un DAO para Spring
@Transactional
public class EstudiantesDAO {
  
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/* applicationContext es el contexto donde todos los 
	beans residen, autowired es la forma de introducir un 
	bean por injection dentro de otro */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void agregarEstudiante(Estudiante estudiante){
		this.getSessionFactory().getCurrentSession().save(estudiante);
	}
	
	public List<Estudiante> getColeccionEstudiantes(){
		List list = this.getSessionFactory().getCurrentSession().createQuery("from Estudiante").list();
		return list;
	}	
}
