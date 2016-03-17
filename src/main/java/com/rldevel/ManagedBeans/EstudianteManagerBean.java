package com.rldevel.ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import com.rldevel.Entities.Estudiante;
import com.rldevel.Services.EstudianteService;

@ManagedBean(name="estudianteManagerBean")
@RequestScoped
public class EstudianteManagerBean implements Serializable{

	private static final long serialVersionUID = 1l;
	
	private String documento;
	private String nombre;
	private String apellido;
	private String fecha_nacimiento;
	List<Estudiante> coleccionEstudiantes;
	
	//Spring Estudiante Service injected
	@ManagedProperty(value="#{estudianteService}")
	EstudianteService estudianteService;
	
   public void agregarEstudiante(){
		try{
			Estudiante estudiante = new Estudiante();
			estudiante.setDocumento(getDocumento());
			estudiante.setNombre(getNombre());
			estudiante.setApellido(getApellido());
			estudiante.setFecha_nacimiento(getFecha_nacimiento());
			estudianteService.agregarEstudiante(estudiante);
			mostrarMensaje();
		}catch(DataAccessException ex){
			ex.printStackTrace(System.err);
		}
	}
	
   private void mostrarMensaje(){
	   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Estudiante agregado correctamente");
	   FacesContext context = FacesContext.getCurrentInstance();
	   context.addMessage(null, message);
   }
   
	public List<Estudiante> getColeccionEstudiantes(){
		coleccionEstudiantes = estudianteService.getColeccionEstudiantes();
		return coleccionEstudiantes;
	}
	
	public void setColeccionEstudiantes(List<Estudiante> coleccionEstudiantes){
		this.coleccionEstudiantes = coleccionEstudiantes;
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public EstudianteService getEstudianteService() {
		return estudianteService;
	}

	public void setEstudianteService(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
