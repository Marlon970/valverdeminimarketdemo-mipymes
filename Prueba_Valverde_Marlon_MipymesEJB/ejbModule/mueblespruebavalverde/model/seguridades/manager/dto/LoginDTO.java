package mueblespruebavalverde.model.seguridades.manager.dto;

import java.util.ArrayList;
import java.util.List;

import examen_valverde.model.component.entities.SegModulo;





public class LoginDTO {
	
	private int idSegUsuario;
	private String correo;
	private List <SegModulo> listamodulos ;
	
	
	public LoginDTO() {
	
		listamodulos = new ArrayList <SegModulo> ();

	}


	public int getIdSegUsuario() {
		return idSegUsuario;
	}


	public void setIdSegUsuario(int idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public List<SegModulo> getListamodulos() {
		return listamodulos;
	}


	public void setListamodulos(List<SegModulo> listamodulos) {
		this.listamodulos = listamodulos;
	}
	
	
	

}
