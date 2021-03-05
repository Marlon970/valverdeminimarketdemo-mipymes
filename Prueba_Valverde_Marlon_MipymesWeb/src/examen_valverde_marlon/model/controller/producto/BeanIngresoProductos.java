package examen_valverde_marlon.model.controller.producto;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import examen_valverde.model.component.entities.DestinoMueble;
import examen_valverde.model.component.entities.InvIngresoProducto;
import examen_valverde.model.component.entities.InvProducto;
import examen_valverde.model.component.entities.ValverdemMueble;
import examen_valverde_marlon.model.manager.producto.ManagerIngresoProducto;
import examen_valverde_marlon.model.manager.producto.ManagerProducto;
import mueblepruebavalverde1.controller.JSFUtil;
import mueblespruebavalverde.model.manager.ManagerDestinoMueble;
import mueblespruebavalverde.model.manager.ManagerMueble;

@Named
@SessionScoped
public class BeanIngresoProductos implements Serializable {
	
	private int idproducto;
	
	private int cantidad;
	
	
	private List<InvProducto> listaproductos;
	private List<InvIngresoProducto> listaingreso;
	
	 @EJB
	 private ManagerProducto managerProducto;
	 @EJB
	 private ManagerIngresoProducto managerIngreso;
	 
@PostConstruct
	 
	 public void inicializar() {
		 
		 listaingreso= managerIngreso.findAllIngresoProducto();
		 listaproductos = managerProducto.findAllMueble();
	 }



public void actionListenerCreaIngreso() {
	try {

		managerIngreso.crearIngresoProducto(idproducto, cantidad);
		// cada ves que se crea un blog se actualiza la tabla
		listaingreso = managerIngreso.findAllIngresoProducto();
		JSFUtil.crearMensajeINFO("Se creado un Ingreso");
	} catch (Exception e) {
		JSFUtil.crearMensajeERROR(e.getMessage());
		e.printStackTrace();
	}

}



public String accionCargarIngresoProducto(){
	
	listaingreso = managerIngreso.findAllIngresoProducto();
	
	return "producto";
	
	
	
}
	 
	

	public BeanIngresoProductos() {
		// TODO Auto-generated constructor stub
	}


	public int getIdproducto() {
		return idproducto;
	}
	
	


	public List<InvProducto> getListaproductos() {
		return listaproductos;
	}


	public void setListaproductos(List<InvProducto> listaproductos) {
		this.listaproductos = listaproductos;
	}


	public List<InvIngresoProducto> getListaingreso() {
		return listaingreso;
	}


	public void setListaingreso(List<InvIngresoProducto> listaingreso) {
		this.listaingreso = listaingreso;
	}


	public ManagerProducto getManagerProducto() {
		return managerProducto;
	}


	public void setManagerProducto(ManagerProducto managerProducto) {
		this.managerProducto = managerProducto;
	}


	public ManagerIngresoProducto getManagerIngreso() {
		return managerIngreso;
	}


	public void setManagerIngreso(ManagerIngresoProducto managerIngreso) {
		this.managerIngreso = managerIngreso;
	}


	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
