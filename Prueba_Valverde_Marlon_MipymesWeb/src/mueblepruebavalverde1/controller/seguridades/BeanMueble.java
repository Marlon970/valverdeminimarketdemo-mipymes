package mueblepruebavalverde1.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import examen_valverde.model.component.entities.ValverdemMueble;
import mueblespruebavalverde.model.seguridades.manager.ManagerSeguridades;


@Named
@SessionScoped
public class BeanMueble implements Serializable {
	
	@EJB
	private ManagerSeguridades mSEguridades;
	
	private List<ValverdemMueble> listamuebles;

	public BeanMueble() {
		// TODO Auto-generated constructor stub
	}
	

	public String accionCargarMuebles(){
		
		listamuebles = mSEguridades.findAllMuebles();
		
		return "mueble1";
		
		
		
	}

	public List<ValverdemMueble> getListamuebles() {
		return listamuebles;
	}

	public void setListamuebles(List<ValverdemMueble> listamuebles) {
		this.listamuebles = listamuebles;
	}
	

}
