package examen_valverde_marlon.model.controller.producto;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import examen_valverde.model.component.entities.InvProducto;
import examen_valverde_marlon.model.manager.producto.ManagerProducto;
import mueblepruebavalverde1.controller.JSFUtil;

@Named
@SessionScoped
public class BeanProducto implements Serializable {
	
	private String nombreproducto;
	private String precioproducto;
	
	private List<InvProducto> listaproducto;
	
	@EJB
	private ManagerProducto managerProducto;
	
	@PostConstruct
	
	public void inicializar() {
		listaproducto = managerProducto.findAllMueble();
	}
	
	public String accionCargarProducto(){
		
		listaproducto = managerProducto.findAllMueble();
		
		return "ingresoproducto";
		
		
		
	}
	
	
	
	public void actionListenerCrearProducto() {

		try {
			managerProducto.crearProducto(nombreproducto, precioproducto);
			listaproducto = managerProducto.findAllMueble();
			JSFUtil.crearMensajeINFO("Mueble Creado");

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}

	}

	
	

	public BeanProducto() {
		// TODO Auto-generated constructor stub
	}



	public String getNombreproducto() {
		return nombreproducto;
	}



	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}



	public String getPrecioproducto() {
		return precioproducto;
	}



	public void setPrecioproducto(String precioproducto) {
		this.precioproducto = precioproducto;
	}



	public List<InvProducto> getListaproducto() {
		return listaproducto;
	}



	public void setListaproducto(List<InvProducto> listaproducto) {
		this.listaproducto = listaproducto;
	}


	


}
