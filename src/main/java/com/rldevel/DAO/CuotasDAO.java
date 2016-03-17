package com.rldevel.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rldevel.Entities.Cuotas;

@Repository
@Transactional
public class CuotasDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void agregarCuota(Cuotas cuota){
		this.getSessionFactory().getCurrentSession().save(cuota);
	}
	
	public List<Cuotas> getColeccionCuotas(){
		List coleccionCuotas = this.getSessionFactory().getCurrentSession().createQuery("from Cuotas").list();
		return coleccionCuotas;
	}
	
}
