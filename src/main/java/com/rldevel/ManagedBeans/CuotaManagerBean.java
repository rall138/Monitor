package com.rldevel.ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import com.rldevel.Entities.Cuotas;
import com.rldevel.Services.CuotasService;

@ManagedBean(name="cuotaManagerBean")
@SessionScoped
public class CuotaManagerBean implements Serializable{

	private int numeroCuota;
	private double valordeCuota;
	List<Cuotas> coleccionCuotas;
	
	//Spring Cuota Service injected
	@ManagedProperty(value="#{cuotasService}")
	CuotasService cuotaService;
	
	public void agregarCuota(){
		try{
			Cuotas cuota = new Cuotas();
			cuota.setNroCuota(numeroCuota);
			cuota.setValorCuota(valordeCuota);
			cuotaService.agregarCuota(cuota);
			mostrarMensaje();
		}catch(DataAccessException ex){
			ex.printStackTrace();
		}
	}
	
   private void mostrarMensaje(){
	   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cuota agregada correctamente");
	   FacesContext context = FacesContext.getCurrentInstance();
	   context.addMessage(null, message);
   }

	public List<Cuotas> getColeccionCuotas() {
		coleccionCuotas = cuotaService.getColeccionCuotas();
		return coleccionCuotas;
	}

	public void setColeccionCuotas(List<Cuotas> coleccionCuotas) {
		this.coleccionCuotas = coleccionCuotas;
	}

	public CuotasService getCuotaService() {
		return cuotaService;
	}

	public void setCuotaService(CuotasService cuotaService) {
		this.cuotaService = cuotaService;
	}

	public int getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public double getValordeCuota() {
		return valordeCuota;
	}

	public void setValordeCuota(double valordeCuota) {
		this.valordeCuota = valordeCuota;
	}
	
	

}
