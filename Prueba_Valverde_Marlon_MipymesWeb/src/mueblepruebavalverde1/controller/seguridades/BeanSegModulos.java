package mueblepruebavalverde1.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import examen_valverde.model.component.entities.SegModulo;
import mueblespruebavalverde.model.seguridades.manager.ManagerSeguridades;




@Named
@SessionScoped
public class BeanSegModulos implements Serializable {
	
	@EJB
	private ManagerSeguridades mSEguridades;
	
	private List<SegModulo> listamodulos;
	
	

	public BeanSegModulos() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String accionCargarMenuModulo(){
		
		listamodulos = mSEguridades.findAllModulos();
		
		return "modulos";
		
		
		
	}


	public List<SegModulo> getListamodulos() {
		return listamodulos;
	}



	public void setListamodulos(List<SegModulo> listamodulos) {
		this.listamodulos = listamodulos;
	}
	
	
	

}
