package com.rldevel.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rldevel.DAO.CuotasDAO;
import com.rldevel.Entities.Cuotas;

@Service("cuotasService")
public class CuotasService {
	
	CuotasDAO cuotasDao;

	public CuotasDAO getCuotasDao() {
		return cuotasDao;
	}

	@Autowired
	public void setCuotasDao(CuotasDAO cuotasDao) {
		this.cuotasDao = cuotasDao;
	}
	
	public void agregarCuota(Cuotas cuota){
		this.cuotasDao.agregarCuota(cuota);
	}
	
	public List<Cuotas> getColeccionCuotas(){
		return this.cuotasDao.getColeccionCuotas();
	}

}
